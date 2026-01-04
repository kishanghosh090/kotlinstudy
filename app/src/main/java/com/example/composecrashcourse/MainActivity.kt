package com.example.composecrashcourse

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecrashcourse.ui.theme.ComposecrashcourseTheme

class MainActivity : ComponentActivity() {
//    private val viewModel by viewModels<SampleViewModel>() //
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposecrashcourseTheme {
                val viewModel = viewModel<SampleViewModel>(

                    factory = object : ViewModelProvider.Factory{
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return SampleViewModel(
                                string = "hello from chai aur code"
                            ) as T
                        }
                    }
                )

                Column(
                    modifier = Modifier.fillMaxSize().background(viewModel.bgColor)

                ) {
                    var isVisible by remember {
                        mutableStateOf(false)
                    }
                    var isRound by remember {
                        mutableStateOf(false)
                    }
                    Button(
                        onClick = {
                            isVisible = !isVisible
                            isRound = !isRound
                            viewModel.changeBackgroudColor()
                        }
                    ) {
                        Text("Toggle")
                    }

                    val borderRadius by animateIntAsState(targetValue = if(isRound) 100 else 0)
                    Box(modifier = Modifier
                            .size(100.dp)
                        .clip(RoundedCornerShape(borderRadius))
                        .background(color = androidx.compose.ui.graphics.Color.Blue)

                    ){

                    }

//                    AnimatedVisibility(
//                        visible = isVisible,
//                        modifier = Modifier.fillMaxWidth().weight(1f),
//                        enter =  slideInVertically() + fadeIn(),
//                        exit =  slideOutVertically() + fadeOut()
//
//                    ) {
//                            Box(modifier = Modifier.background(color = androidx.compose.ui.graphics.Color.Red)) { }
//                    }




                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        print("onPause()")

    }

    override fun onResume() {
        super.onResume()
        print("onResume()")

    }

    override fun onRestart() {
        super.onRestart()
        print("onRestart()")


    }
    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy()")
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposecrashcourseTheme {

    }
}