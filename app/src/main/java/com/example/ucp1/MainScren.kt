package com.example.ucp1


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun MainScren(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize()){
        SectionHeader()

        var email by remember { mutableStateOf( "") }
        var alamat by remember { mutableStateOf("") }
        var noHp by remember { mutableStateOf("") }
        var selectedTahun by remember { mutableStateOf("") }

        val tahunmasuk = listOf("2020", "2021", "2022")
        var emailUser by remember { mutableStateOf( "") }
        var alamatUser by remember { mutableStateOf("") }
        var noHpUser by remember { mutableStateOf("") }
        var selectedTahunUser by remember { mutableStateOf("") }

        Column(Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(value = email,
                onValueChange = {email = it},
                placeholder = { Text("Masukkan Email anda")
                }, label = { Text("Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                ,modifier = Modifier.fillMaxWidth().padding(5.dp))
            OutlinedTextField(value = noHp,
                onValueChange = {noHp = it},
                placeholder = { Text("Masukkan noHp anda")
                }, label = { Text("NoHp")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                ,modifier = Modifier.fillMaxWidth().padding(5.dp))
            OutlinedTextField(value = alamat,
                onValueChange = {alamat = it},
                placeholder = { Text("Masukkan Alamat anda")
                }, label = { Text("Alamat")}
                ,modifier = Modifier.fillMaxWidth().padding(5.dp))
            Row {
                tahunmasuk.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically){ RadioButton(
                        selected = selectedTahun == item,
                        onClick = {
                            selectedTahun = item
                        })
                        Text(item)
                    }
                }
            }

            Button(onClick = {
                emailUser = email
                alamatUser = alamat
                noHpUser = noHp
                selectedTahunUser = selectedTahun

            }) { Text("Simpan") }
            Card(modifier.size(width = 300.dp, height = 200.dp)){
                MainSection(params = "Email", isiparms = emailUser)
                MainSection(params = "Alamat", isiparms = alamatUser)
                MainSection(params = "NoHp", isiparms = noHpUser)
                MainSection(params = "tahun masuk", isiparms = selectedTahunUser)
            }


        }
    }



}

@Composable
fun SectionHeader(){
    Box(modifier = Modifier.fillMaxWidth()
        .background(color = Color(red = 164, green = 198, blue = 57)) ){
        Row(
            modifier = Modifier.padding(8.dp)
        ){
            Box(contentAlignment = Alignment.BottomEnd){
                Image(
                    painter = painterResource(id = R.drawable.a),
                    contentDescription = "",
                    Modifier.size(100.dp).clip(shape = CircleShape)
                )
                Icon(
                    Icons.Filled.Build, contentDescription = "",
                    Modifier.padding(end = 5.dp).size(25.dp),
                    tint = Color.Red)

            }
            Column(Modifier.padding(15.dp)) {
                Text(text = "Halo,",
                    color = Color.White)
                Spacer(Modifier.padding(3.dp))
                Text(text = "Rangga Hijriawan Haryadi",
                    color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
@Composable
fun MainSection(params: String, isiparms: String){
    Column(horizontalAlignment = Alignment.Start){

        Row(modifier = Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = params, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiparms",
                modifier = Modifier.weight(2f))
        }
    }
}



