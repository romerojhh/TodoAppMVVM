package com.example.todoappmvvm.ui.todo_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoappmvvm.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun TodoListScreen(
    // function to navigate between screens
    onNavigate: (UiEvent.Navigate) -> Unit,
    
    // viewModel contains the state of the screen. Uses hilt
    viewModel: TodoListViewModel = hiltViewModel()
) {
    val todos = viewModel.todos.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    
    // Code block in LaunchedEffect will be executed independently
    // since composable function is called every single time the screen updates
    LaunchedEffect(key1 = true) {
        
        // the code below will get executed everytime
        // TodoListViewModel.sendUiEvent() is called
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                    
                    // If user click undo button
                    if (result == SnackbarResult.ActionPerformed) {
                        viewModel.onEvent(TodoListEvent.OnUndoDeleteClick)
                    }
                }

                is UiEvent.Navigate -> onNavigate(event)
                
                // else we don't do anything
                else -> Unit
            }
        }
    }
    
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(TodoListEvent.OnAddTodoClick)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        // Inside the scaffold, we want to view or list of todo items
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(todos.value) { todo ->
                TodoItem(
                    todo = todo,
                    // transfer how we handle event to TodoListViewModel class
                    // without having to copy codes from TodoListViewModel
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onEvent(TodoListEvent.OnTodoClick(todo))
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}