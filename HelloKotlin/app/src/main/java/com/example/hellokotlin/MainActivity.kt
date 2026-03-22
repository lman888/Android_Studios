package com.example.hellokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hellokotlin.ui.theme.HelloKotlinTheme

val school = listOf("Mackerel", "Trout", "Halibut");
val numbers = listOf(1, 2, 3, 4);
val oceans = listOf("Pacific", "Atlantic")
val oddList = listOf(school, numbers, oceans)

val waterTemp = 10
val waterTempMessage = "The water temperature is ${ if (waterTemp > 50) "too warm" else "Ok!"}"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        print("Hello Kotlin!")
        printList(school)
        printOverloadList(oddList)

        print(waterTempMessage)
        swim()
        swim("slow")

        buildAquariam()

        getAquariumType()
    }
}

open class Aquarium(var width: Int = 20, var height: Int = 40, var length: Int = 100)
{
    public fun printSize()
    {
        println("Width: $width cm " + "Height: $height cm " + "Length: $length cm")
    }
}

class AquariumType : Aquarium()
{
    public fun getAquariumSize()
    {
        printSize()

        getAquariamType()
    }

    private fun getAquariamType()
    {
        println("Large")
    }
}

fun getAquariumType()
{
    val myAquariumType = AquariumType()
    myAquariumType.getAquariumSize()
}
fun buildAquariam()
{
    val myAquarium = Aquarium(10, 20, 40)
    myAquarium.printSize()
    myAquarium.width = 100
    myAquarium.height = 200
    myAquarium.length = 500
    myAquarium.printSize()
}
fun print(name: String)
{
    println(name)
}

fun swim(speed: String = "Fast")
{
    println("Swinning $speed")
}

fun printList(items: List<String>)
{
    for(item in items)
    {
        println(item)
    }
}

fun printOverloadList(items: List<Any>)
{
    for(item in items)
    {
        println(item)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloKotlinTheme {
        Greeting("Android")
    }
}