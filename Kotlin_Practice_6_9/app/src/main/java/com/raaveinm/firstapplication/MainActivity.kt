package com.raaveinm.firstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raaveinm.firstapplication.ui.theme.FirstApplicationTheme
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import kotlin.random.Random
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ShoppingCartScreen()
                    }
                }
            }
        }
    }
}

// ==========================================
// ЗАДАНИЕ 1: Приветствие (null-безопасность)
// ==========================================
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    val greeting = if (name != null) {
        "Привет, $name!"
    } else {
        "Имя не задано"
    }
    Text(text = greeting, modifier = modifier)
}

@Preview(showBackground = true, name = "Портрет")
@Composable
fun HelloPreviewPortrait() {
    FirstApplicationTheme { Hello("Портрет") }
}

@Preview(showBackground = true, name = "Ландшафт", device = "spec:width=891dp,height=411dp,orientation=landscape")
@Composable
fun HelloPreviewLandscape() {
    FirstApplicationTheme { Hello("Ландшафт") }
}

@Preview(showBackground = true, name = "Круглый", device = "spec:width=200dp,height=200dp,isRound=true", backgroundColor = 0xFFFF00)
@Composable
fun HelloPreviewRound() {
    FirstApplicationTheme { Hello("Круглый") }
}

// ==========================================
// ЗАДАНИЕ 3: Стилизованные тексты
// ==========================================
@Composable
fun JetpackComposeText() {
    Column {
        Text(
            text = stringResource(id = R.string.jetpack_compose_description),
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth().padding(top = 48.dp)
        )
        Text(
            text = "Стилизованный текст",
            fontSize = 24.sp,
            color = Color.Black,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.fillMaxWidth().background(Color.Green)
        )
    }
}

@Preview(showBackground = true, name = "Задание 3")
@Composable
fun JetpackComposeTextPreview() {
    FirstApplicationTheme { JetpackComposeText() }
}

// ==========================================
// ЗАДАНИЕ 4: Кастомная кнопка
// ==========================================
@Composable
fun CustomButton() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black)
    ) {
        Text(text = "Нажми на меня")
    }
}

@Preview(showBackground = true, name = "Кнопка")
@Composable
fun CustomButtonPreview() {
    FirstApplicationTheme { CustomButton() }
}

// ==========================================
// ЗАДАНИЕ 5: Профиль с аватаром
// ==========================================
@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier.fillMaxWidth().height(100.dp).background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 16.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Саша", color = Color.Black, fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true, name = "Профиль")
@Composable
fun ProfileHeaderPreview() {
    FirstApplicationTheme { ProfileHeader() }
}

// ==========================================
// ЗАДАНИЕ 6: Векторная графика (Круги)
// ==========================================
@Composable
fun CircleTopEnd() {
    Box(
        modifier = Modifier.size(width = 240.dp, height = 120.dp).background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(painter = painterResource(id = R.drawable.circle), contentDescription = "Круг")
    }
}

@Preview(showBackground = true, name = "Задание 6.1")
@Composable
fun CircleTopEndPreview() {
    FirstApplicationTheme { CircleTopEnd() }
}

@Composable
fun CircleStretched() {
    Box(
        modifier = Modifier.size(width = 240.dp, height = 120.dp).background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color.Magenta)
        )
    }
}

@Preview(showBackground = true, name = "Задание 6.2")
@Composable
fun CircleStretchedPreview() {
    FirstApplicationTheme { CircleStretched() }
}

// ==========================================
// ЗАДАНИЕ 7: Контакты (Column и Row)
// ==========================================
@Composable
fun ContactCard(name: String, phone: String) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.LightGray).padding(8.dp)
    ) {
        Text(text = "Имя: $name")
        Text(text = "Телефон: $phone")
    }
}

@Composable
fun ContactColumn() {
    Column(modifier = Modifier.fillMaxSize()) {
        ContactCard("Евгений", "+7 495 495 95 95")
        Spacer(modifier = Modifier.height(8.dp))
        ContactCard("Василий", "—")
        Spacer(modifier = Modifier.height(8.dp))
        ContactCard("Геннадий", "+7 495 788 78 78")
    }
}

@Preview(showBackground = true, name = "Задание 7. Column")
@Composable
fun ContactColumnPreview() {
    FirstApplicationTheme { ContactColumn() }
}

@Composable
fun ContactRow() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactCard("Евгений", "+7 495 495 95 95")
        ContactCard("Василий", "—")
    }
}

@Preview(showBackground = true, name = "Задание 7. Row")
@Composable
fun ContactRowPreview() {
    FirstApplicationTheme { ContactRow() }
}

// ==========================================
// ЗАДАНИЕ 8: Трекер воды
// ==========================================
@Composable
fun WaterTracker() {
    var waterCount by remember { mutableStateOf(750) }
    var daysCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Трекер воды", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.Blue)
        Spacer(modifier = Modifier.height(48.dp))
        Text(text = "$waterCount мл", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { waterCount += 250 }) {
            Text(text = "+250 мл", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (waterCount >= 1500) {
                daysCount += 1
            } else {
                daysCount = 0
            }
            waterCount = 0
        }) {
            Text(text = "Завершить день", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Дней подряд: $daysCount", fontSize = 20.sp)
    }
}

@Preview(showBackground = true, name = "Задание 8")
@Composable
fun WaterTrackerPreview() {
    FirstApplicationTheme { WaterTracker() }
}


// ЗАДАНИЕ 10: Корзина товаров (Исправление ошибок)
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current

    // Правильное состояние для списка товаров
    var cart by remember { mutableStateOf(listOf<Product>()) }

    // Сумма считается автоматически на основе списка
    val totalSum = cart.sumOf { it.price }

    // Показываем Toast, если сумма > 500
    LaunchedEffect(totalSum) {
        if (totalSum > 500) {
            Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Вывод списка товаров
        cart.forEach { product ->
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        Spacer(modifier = Modifier.height(20.dp))

        // Кнопка "Добавить товар"
        Button(
            onClick = {
                val newProduct = Product(
                    id = cart.size,
                    name = "Товар #${cart.size + 1}",
                    price = Random.nextInt(0, 100)
                )
                cart = cart + newProduct
            }
        ) {
            Text(text = "Добавить товар")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Кнопка "Удалить товар" (показывается только если есть товары)
        if (cart.isNotEmpty()) {
            Button(
                onClick = {
                    cart = cart.dropLast(1)
                }
            ) {
                Text(text = "Удалить товар")
            }
        }
    }
}

@Preview(showBackground = true, name = "Задание 10")
@Composable
fun ShoppingCartPreview() {
    FirstApplicationTheme {
        ShoppingCartScreen()
    }
}
// ==========================================
// ЗАДАНИЕ 10 (ДО): Код джуниора с ошибками
// ==========================================

@Composable
fun JuniorShoppingCartScreen() {
    var totalSum = 0
    var productSize = 0

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    Column {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
            totalSum += product.price
            productSize++
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection {
            products = products + Product(
                id = products.size,
                name = "Товар #${products.size + 1}",
                price = Random.nextInt(0, 100)
            )
        }

        RemoveProductSection {
            products = products.dropLast(1)
        }
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    // ОШИБКА: Toast вызывается прямо в Composable (побочный эффект)
    if (true) {
        // В оригинале тут был totalSum, но он вне зоны видимости,
        // поэтому джуниор допустил еще одну ошибку.
        // Для демонстрации оставим так.
    }

    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(onRemove: () -> Unit) {
    if (true) { // ОШИБКА: productSize не State, кнопка видна всегда
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}