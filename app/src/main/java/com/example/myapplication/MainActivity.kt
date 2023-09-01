package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var displayedSentence by remember { mutableStateOf<String?>(null) }

                    Column(
                        modifier = Modifier
                            //.fillMaxSize()
                            //.padding(horizontal = 16.dp),
                            .size(400.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyImage()
                        Introduction(text = "Hello, My name is Fenix, and in this app I will be showing some information about myself, Enjoy!")
                        displayedSentence?.let {
                            when (it) {
                                "sentence1" -> Sentence1(name = "Fenix", age = 26)
                                "sentence2" -> Sentence2(school = "HKR", field = "Computer Science")
                                "sentence3" -> Sentence3(hobby1 = "Coding", hobby2 = "Painting", hobby3 = "Cooking")
                                "sentence4" -> Sentence4(hobby2 = "Painting")
                                "sentence5" -> Sentence5(language1= "Turkish", language2 = "Swedish", language3 = "Kurdish", language4 = "English")
                                "sentence6" -> Sentence6(Code1 ="C#" , Code2 = "Java", Code3="Kotlin")
                                "sentence7" -> Sentence7(Show1="Stranger Things",Show2="Breaking Bad")
                                "sentence8" -> Sentence8(quality1 = "Driven", quality2 = "Caring", quality3= "Ambitious")
                                "sentence9" -> Sentence9(topic1 = "Women's rights", topic2 = "Equality", topic3 = "Inclusiveness")
                                "sentence10"-> Sentence10(opinion1 ="easy to understand", opinion2 = "easy to read", opinion3="over all great")
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))



                        SmallButton(
                            text = "Click here",
                            selectedSentence = displayedSentence,
                            onClick = {
                                val randomNum = Random.nextInt(10)
                                displayedSentence = when (randomNum) {
                                    0 -> "sentence1"
                                    1 -> "sentence2"
                                    2 -> "sentence3"
                                    3 -> "sentence4"
                                    4 -> "sentence5"
                                    5 -> "sentence6"
                                    6 -> "sentence7"
                                    7 -> "sentence8"
                                    8 -> "sentence9"
                                    else -> "sentence10"
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun MyImage(modifier: Modifier  = Modifier){
    Image(
        painter = painterResource(id = R.drawable.ben),
        contentDescription = null,
        modifier = modifier
            .background(Color.LightGray)
            .size(400.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Fit


    )
}

@Composable
fun Introduction(text: String, modifier: Modifier = Modifier){
    Text (text= text,
        modifier = modifier,
        color = Color.Black,
        fontSize = 19.sp,
        lineHeight = 19.sp,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center

    )
}

@Composable
fun SmallButton(text: String, selectedSentence: String?, onClick: () -> Unit) {

        Button(
            onClick = onClick,
            modifier = Modifier
                .width(150.dp)
                .height(36.dp),

            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                text = text,
                fontSize = 14.sp
            )
        }
    }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
                .background(Color.Cyan)
                .padding(16.dp)
                .background(Color.Magenta),

            color = Color.White,
            fontSize = 15.sp
    )
}

@Composable
fun Sentence1(name: String, age: Int, modifier: Modifier = Modifier){

    Text(
        text = "My name is $name and I am $age years old",
        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize = 15.sp
    )
}

@Composable
fun Sentence2(school: String, field: String, modifier: Modifier = Modifier){
    Text(
        text = "I am studying at $school, the programme $field",
        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize = 15.sp
    )

}

@Composable
fun Sentence3(hobby1: String, hobby2: String, hobby3: String, modifier: Modifier = Modifier){
    Text(
        text = "My Hobbies are $hobby1, $hobby2 and $hobby3.",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize = 15.sp

    )
}

@Composable
fun Sentence4(hobby2: String, modifier:Modifier = Modifier){
    Text(
        text="My favorite hobby of them all is $hobby2 because I like that I can freely express myself when $hobby2",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize= 15.sp
    )
}


@Composable
fun Sentence5(language1: String,language2:String, language3:String, language4:String, modifier:Modifier = Modifier){
    Text(
        text= "I can speak four languages fluently, there are: \n $language1, $language2, $language3 and $language4",




        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize= 15.sp
    )
}


@Composable
fun Sentence6(Code1: String,Code2:String, Code3:String, modifier:Modifier = Modifier){
    Text(
        text= "My favorite programming languages are: \n $Code1, $Code2 and $Code3",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize= 15.sp
    )
}

@Composable
fun Sentence7(Show1: String, Show2: String, modifier:Modifier = Modifier){
    Text(
        text= "My favorite shows are: \n $Show1 and $Show2",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize= 15.sp
    )
}

@Composable
fun Sentence8(quality1: String, quality2: String, quality3:String,modifier:Modifier = Modifier){
    Text(
        text= "My friends describe me as: \n $quality1, $quality2 and $quality3",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize= 15.sp
    )
}

@Composable
fun Sentence9(topic1:String, topic2: String, topic3: String, modifier: Modifier = Modifier){
    Text(
        text= "The topics that I am passionate about are: \n $topic1, $topic2 and $topic3",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize = 15.sp

    )
}

@Composable
fun Sentence10(opinion1 :String, opinion2 : String, opinion3 : String, modifier:Modifier = Modifier){

    Text(
        text= "I would say kotlin is a very $opinion1, $opinion2 and $opinion3 programming language.",

        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .background(Color.DarkGray)
            .fillMaxWidth(),

        color = Color.White,
        fontSize = 15.sp
    )
}
@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyApplicationTheme {
        Surface {
            MainActivity()
        }
    }
}



// Add picture, center the button



//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("You are so fucking slow")
    }
}