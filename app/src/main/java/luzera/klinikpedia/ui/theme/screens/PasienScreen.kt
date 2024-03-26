package luzera.klinikpedia.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.room.Room
import luzera.klinikpedia.persistences.AppDatabase

@Composable
fun PasienScreen() {
    val context = LocalContext.current

    val db = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
    val pasienDao = db.pasienDao()

    Column(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
        FormPasienScreen(pasienDao)

        ListPasienScreen(pasienDao)
    }
}