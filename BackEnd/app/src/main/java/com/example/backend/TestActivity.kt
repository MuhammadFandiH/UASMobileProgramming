package com.example.backend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_test.*
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class TestActivity : AppCompatActivity() {

    internal var pernyataanArray = ArrayList<ArrayList<String>>()

    val pernyataan1 = arrayOf(
        "Saya suka bercerita, termasuk cerita dongeng dan cerita yang lucu",
        "Saya memiliki ingatan yang baik untuk hal-hal yang sepele",
        "Saya menyukai permainan kata-kata (seperti srabble dan puzzle)",
        "Membaca buku adalah hobi saya",
        "Saya seorang pembicara yang baik (hampir setiap waktu)",
        "Dalam berargumentasi, saya cenderung menggunakan kata-kata sindiran",
        "Saya senang membicarakan dan menulis ide-ide saya",
        "Jika saya harus mengingat sesuatu, saya menciptakan irama atau kata-kata yang membantu saya untuk mengingatnya",
        "Jika sesuatu rusak dan tidak berfungsi, maka saya akan membaca buku panduannya terlebih dahulu",
        "Dalam kerja kelompok (untuk mempersiapkan presentasi), saya lebih memilih untuk menulis dan melakukan riset pustaka"
    )
    val pernyataan2 = arrayOf(
        "Saya sangat menikmati pelajaran matematika",
        "Saya menyukai permainan yang menggunakan logika, seperti teka-teki angka",
        "Dapat memecahkan soal hitungan adalah hal yang menyenangkan bagi saya",
        "Jika saya harus mengingat sesuatu, saya cenderung menempatkan setiap kejadian dalam urutan yang logis",
        "Saya senang mencari tahu bagaimana cara kerja setiap benda",
        "Saya menyukai komputer dan berbagai permainan angka-angka",
        "Saya suka bermain catur atau monopoli",
        "Dalam berargumentasi, saya mencoba mencari solusi yang adil dan logis",
        "Jika sesuatu rusak dan tidak berfungsi, saya melihat bagian (atau komponennya) dan mencari tahu bagaimana cara kerjanya",
        "Dalam kerja kelompok, saya lebih memilih membuat diagram dan grafik"
    )
    val pernyataan3 = arrayOf(
        "Saya lebih memilih peta daripada petunjuk tertulis dalam mencari sebuah alamat",
        "Saya sering melamun",
        "Saya menikmati hobi saya dalam bidang fotografi",
        "Saya senang menggambar dan menciptakan sesuatu",
        "Jika saya harus mengingat sesuatu, saya menggambar diagram untuk membantu saya mengingatnya",
        "Saya senang membuat coretan-coretan di kertas kapanpun saya bisa",
        "Ketika membaca majalah, saya lebih suka melihat gambaar-gambarnya daripada membaca teksnya",
        "Dalam berargumentasi, saya mencoba menjaga jarak, tetap berdiam diri, atau memvisualisasikan beberapa solusi",
        "Jika sesuatu rusak dan tidak berfungsi, saya cenderung mempelajari diagram mengenai cara kerjanya",
        "Dalam kerja kelompok, saya lebih memilih menggambar hal-hal yang penting"
    )
    val pernyataan4 = arrayOf(
        "Sejak suka berolahraga, senam menjadi olahraga favorit saya",
        "Saya menyukai kegiatan-kegiatan seperti pertukangan, menjahit, dan membuat bentuk-bentuk",
        "Ketika melihat benda-benda, saya senang menyentuhnya",
        "Saya tidak suka duduk diam dalam waktu yang lama",
        "Saya menggunakan banyak gerakan tubuh ketika berbicara",
        "Jika saya harus mengingat sesuatu, saya menuliskannya berkali-kali sampai saya memahaminya",
        "Saya cenderung mengetuk-ngetukkan jari saya atau memainkan pena/pensil selama jam pelajaran",
        "Dalam berargumentasi, saya cenderung menyerang atau menghindarinya",
        "Jika sesuatu rusak dan tidak berfungsi, saya cenderung memisahkan setiap bagian lalu menggabungkannya kembali",
        "Dalam kerja kelompok, saya lebih memilih memindahkan barang atau membuat suatu bentuk"
    )
    val pernyataan5 = arrayOf(
        "Saya senang mendengarkan musik dan radio",
        "Saya cenderung bersenandung ketika sedang bekerja",
        "Saya suka bernyanyi",
        "Saya bisa memainkan salah satu alat musik dengan baik",
        "Saya suka mendengarkan musik sambil belajar atau sambil membaca buku",
        "Jika saya harus mengingat sesuatu, saya mencoba untuk membuat irama tentang hal tersebut",
        "Dalam berargumentasi, saya cenderung berteriak atau memukul (meja/benda) atau bergerak dalam suatu irama",
        "Saya bisa menghafal nada-nada dari banyak lagu",
        "Jika sesuatu rusak dan tidak berfungsi, saya cenderung mengetuk-ngetuk jari saya membentuk suatu irama sambil mencari jalan keluar",
        "Dalam kerja kelompok, saya lebih suka menggunakan kata-kata baru pada nada atau musik yang sudah dikenal"
    )
    val pernyataan6 = arrayOf(
        "Saya mampu bergaul baik dengan orang lain",
        "Saya senang berkumpul dan berorganisasi",
        "Saya mempunyai beberapa teman dekat",
        "Saya suka membantu mengajar murid-murid lain.",
        "Saya suka bekerja sama dalam kelompok",
        "Teman-teman sering meminta saran dari saya karena saya terlihat sebagai pemimpin alamiah",
        "Jika saya harus mengingat sesuatu, saya meminta seseorang untuk menguji saya apakah saya sudah memahaminya",
        "Dalam berorganisasi, saya cennderung meminta bantuan teman atau pihak yang memiliki otoritas (ahli) dalam bidang tersebut",
        "Jika sesuatu rusak dan tidak berfungsi, saya mencari seseorang yang dapat menolong saya",
        "Dalam kerja kelompok, saya lebih memilih mengatur tugas dalam kelompok"
    )
    val pernyataan7 = arrayOf(
        "Saya suka bekerja sendirian tanpa ada gangguan orang lain",
        "Saya suka menulis buku harian",
        "Saya menyukai diri saya (hampir setiap waktu)",
        "Saya tidak suka keramaian",
        "Saya tahu kelebihan dan kekurangan diri saya",
        "Saya memiliki tekad yJang kuat, mandiri dan berpendirian kuat (tidak mudah ikut-ikutan orang lain)",
        "Jika saya harus mengingat sesuatu, saya cenderung menutup mata saya dan mendalami (merasakan) situasi yang sedang terjadi",
        "Dalam berargumentasi, saya biasanya menghindar (keluar ruangan) hingga saya dapat menenangkan diri",
        "Jikaa sesuatu rusak dan tidak berfungsi, saya mempertimbangkan apakah benda tersebut layak untuk diperbaiki",
        "Dalam kerja kelomopk, saya senang mengkontribusikan sesuatu yang unk berdasarkan apa yang saya miliki dan rasakan"
    )
    val pernyataan8 = arrayOf(
        "Saya sangat memperhatikan sekeliling dan apa yang sedang terjadi di sekitar saya",
        "Saya senang berjalan-jalan di hutan (atau taman) dan melihat-lihat pohon serta bunga",
        "Saya senang berkebun",
        "Saya suka mengoleksi barang-barang seperti batu-batuan, kartu olahraga, perangko, dsb",
        "Ketika dewasa,",
        "Jika saya harus mengingat sesuatu, saya cenderung mengkategorikan dalam kelompok-kelompok",
        "Saya senang mempelajari nama-nama maakhluk hidup di lingkungan tempat saya berada, seperti bunga dan pohon",
        "Dalam berargumentasi, saya cenderung membandingkan lawan saya dengan seseorang atau sesuatu yang pernah saya baca atau dengar, lalu bereaksi",
        "Jika sesuatu rusak dan tidak berfungsi, saya memperhatikan sekeliling saya ntuk melihat apa yang bisa saya temukan untuk memperbaikinya",
        "Dalam kerja kelompok, saya lebih memilih mengatur dan mengelompokkan informasi dalam kategori-kategori sehingga mudah dimengeri"
    )

    val jmlper1 = 0
    val jmlper2 = 0
    val jmlper3 = 0
    val jmlper4 = 0
    val jmlper5 = 0
    val jmlper6 = 0
    val jmlper7 = 0
    val jmlper8 = 0

    val getpoin1 = 1
    val getpoin2 = 2
    val getpoin3 = 3
    val getpoin4 = 4
    val getpoin5 = 5

    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        for (i in pernyataan1.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan1[i])

            pernyataanArray.add(tmpArray)
            cekjawaban1()
        }

        for (i in pernyataan2.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan2[i])

            pernyataanArray.add(tmpArray)
            cekjawaban2()
        }

        for (i in pernyataan3.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan3[i])

            pernyataanArray.add(tmpArray)
            cekjawaban3()
        }

        for (i in pernyataan4.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan4[i])

            pernyataanArray.add(tmpArray)
            cekjawaban4()
        }

        for (i in pernyataan5.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan5[i])

            pernyataanArray.add(tmpArray)
            cekjawaban5()
        }

        for (i in pernyataan6.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan6[i])

            pernyataanArray.add(tmpArray)
            cekjawaban6()
        }

        for (i in pernyataan7.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan7[i])

            pernyataanArray.add(tmpArray)
            cekjawaban7()
        }

        for (i in pernyataan8.indices){
            val tmpArray = ArrayList<String>()
            tmpArray.add(pernyataan8[i])

            pernyataanArray.add(tmpArray)
            cekjawaban8()
        }

        getsoal()
    }

    public fun getsoal() {

        val random = Random()
        val randomNum = random.nextInt(pernyataanArray.size)
        val perny = pernyataanArray.get(randomNum)
        txtPernyataan.setText(perny.get(0))

        pernyataanArray.removeAt(randomNum)

        btn1.setOnClickListener{
            if (pernyataanArray.size < 1) {
                startActivity(Intent(this@TestActivity,HasilTestActivity::class.java))
                finish()
            }else{
                val intent = Intent(context, TestActivity::class.java)
                val random = Random()
                val randomNum = random.nextInt(pernyataanArray.size)
                val perny = pernyataanArray.get(randomNum)

                txtPernyataan.setText(perny.get(0))
                getpoin1
                pernyataanArray.removeAt(randomNum)
            }
        }

        btn2.setOnClickListener{
            if (pernyataanArray.size < 1) {
                startActivity(Intent(this@TestActivity,HasilTestActivity::class.java))
                finish()
            }else{
                val intent = Intent(context, TestActivity::class.java)
                val random = Random()
                val randomNum = random.nextInt(pernyataanArray.size)
                val perny = pernyataanArray.get(randomNum)

                txtPernyataan.setText(perny.get(0))
                getpoin2
                pernyataanArray.removeAt(randomNum)
            }
        }

        btn3.setOnClickListener{
            if (pernyataanArray.size < 1) {
                startActivity(Intent(this@TestActivity,HasilTestActivity::class.java))
                finish()
            }else{
                val intent = Intent(context, TestActivity::class.java)
                val random = Random()
                val randomNum = random.nextInt(pernyataanArray.size)
                val perny = pernyataanArray.get(randomNum)

                txtPernyataan.setText(perny.get(0))
                getpoin3
                pernyataanArray.removeAt(randomNum)
            }
        }

        btn4.setOnClickListener{
            if (pernyataanArray.size < 1) {
                startActivity(Intent(this@TestActivity,HasilTestActivity::class.java))
                finish()
            }else{
                val intent = Intent(context, TestActivity::class.java)
                val random = Random()
                val randomNum = random.nextInt(pernyataanArray.size)
                val perny = pernyataanArray.get(randomNum)

                txtPernyataan.setText(perny.get(0))
                getpoin4
                pernyataanArray.removeAt(randomNum)
            }
        }

        btn5.setOnClickListener{
            if (pernyataanArray.size < 1) {
                startActivity(Intent(this@TestActivity,HasilTestActivity::class.java))
                finish()
            }else{
                val intent = Intent(context, TestActivity::class.java)
                val random = Random()
                val randomNum = random.nextInt(pernyataanArray.size)
                val perny = pernyataanArray.get(randomNum)

                txtPernyataan.setText(perny.get(0))
                getpoin5
                pernyataanArray.removeAt(randomNum)
            }
        }
    }

    public fun cekjawaban1() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper1 + 1
        }else if(answer.equals(getpoin2)){
            jmlper1 + 2
        }else if (answer.equals(getpoin3)){
            jmlper1 + 3
        }else if (answer.equals(getpoin4)){
            jmlper1 + 4
        }else{
            jmlper1 + 5
        }
        hasil()
    }
    public fun cekjawaban2() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper2 + 1
        }else if(answer.equals(getpoin2)){
            jmlper2 + 2
        }else if (answer.equals(getpoin3)){
            jmlper2 + 3
        }else if (answer.equals(getpoin4)){
            jmlper2 + 4
        }else{
            jmlper2 + 5
        }
        hasil()
    }
    public fun cekjawaban3() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper3 + 1
        }else if(answer.equals(getpoin2)){
            jmlper3 + 2
        }else if (answer.equals(getpoin3)){
            jmlper3 + 3
        }else if (answer.equals(getpoin4)){
            jmlper3 + 4
        }else{
            jmlper3 + 5
        }
        hasil()
    }
    public fun cekjawaban4() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper4 + 1
        }else if(answer.equals(getpoin2)){
            jmlper4 + 2
        }else if (answer.equals(getpoin3)){
            jmlper4 + 3
        }else if (answer.equals(getpoin4)){
            jmlper4 + 4
        }else{
            jmlper4 + 5
        }
        hasil()
    }
    public fun cekjawaban5() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper5 + 1
        }else if(answer.equals(getpoin2)){
            jmlper5 + 2
        }else if (answer.equals(getpoin3)){
            jmlper5 + 3
        }else if (answer.equals(getpoin4)){
            jmlper5 + 4
        }else{
            jmlper5 + 5
        }
        hasil()
    }
    public fun cekjawaban6() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper6 + 1
        }else if(answer.equals(getpoin2)){
            jmlper6 + 2
        }else if (answer.equals(getpoin3)){
            jmlper6 + 3
        }else if (answer.equals(getpoin4)){
            jmlper6 + 4
        }else{
            jmlper6 + 5
        }
        hasil()
    }
    public fun cekjawaban7() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper7 + 1
        }else if(answer.equals(getpoin2)){
            jmlper7 + 2
        }else if (answer.equals(getpoin3)){
            jmlper7 + 3
        }else if (answer.equals(getpoin4)){
            jmlper7 + 4
        }else{
            jmlper7 + 5
        }
        hasil()
    }
    public fun cekjawaban8() {
        val answer = btn1.getText().toString().toLowerCase()

        if (answer.equals(getpoin1)){
            jmlper8 + 1
        }else if(answer.equals(getpoin2)){
            jmlper8 + 2
        }else if (answer.equals(getpoin3)){
            jmlper8 + 3
        }else if (answer.equals(getpoin4)){
            jmlper8 + 4
        }else{
            jmlper8 + 5
        }
        hasil()
    }

    public fun hasil() {

//        var nilai1 = toString()
//        var nilai2 = toString()
//
//        val hasilnilai = arrayOf(
//            "Kecerdasan Verbal/Linguistik",
//            "Kecerdasan Logis/Matematis",
//            "Kecerdasan Visual/Spasial",
//            "Kecerdasan Kinestetik",
//            "Kecerdasan Musikal",
//            "Kecerdasan Interpersonal",
//            "Kecerdasan Intrapersonal",
//            "Kecerdasan Naturalis"

//        )

//        if (jmlper1 > jmlper2 && jmlper1 > jmlper3 && jmlper1 > jmlper4 && jmlper1 > jmlper5 &&
//            jmlper1 > jmlper6 && jmlper1 > jmlper7 && jmlper1 > jmlper8 && jmlper2 > jmlper3 &&
//            jmlper2 > jmlper4 && jmlper2 > jmlper5 && jmlper2 > jmlper6 && jmlper2 > jmlper7 &&
//            jmlper2 > jmlper8 ){
//            nilai1 = hasilnilai[0]
//            nilai2 = hasilnilai[1]
//        }else if (
//             jmlper1 > jmlper2 && jmlper1 > jmlper3 && jmlper1 > jmlper4 && jmlper1 > jmlper5 &&
//             jmlper1 > jmlper6 && jmlper1 > jmlper7 && jmlper1 > jmlper8 && jmlper3 > jmlper4 &&
//             jmlper3 > jmlper5 && jmlper3 > jmlper6 && jmlper3 > jmlper7 && jmlper3 > jmlper8) {
//            nilai1 = hasilnilai[0]
//            nilai2 = hasilnilai[2]
//        }else if (
//            jmlper1 > jmlper2 && jmlper1 > jmlper3 && jmlper1 > jmlper4 && jmlper1 > jmlper5 &&
//            jmlper1 > jmlper6 && jmlper1 > jmlper7 && jmlper1 > jmlper8 && jmlper3 > jmlper4 &&
//            jmlper3 > jmlper5 && jmlper3 > jmlper6 && jmlper3 > jmlper7 && jmlper3 > jmlper8
//                ){
//
//        }

//        val Intent = Intent(context,HasilTestActivity::class.java)
//        intent.putExtra(nilai1,hasilnilai)
//        intent.putExtra(nilai2,hasilnilai)
//        startActivity(intent)
//        finish()
    }
}
