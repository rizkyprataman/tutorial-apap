# Tutorial APAP
## Authors
* **Rizky Pratama Nataprawira** - *1906318514* - *B*
---
## Tutorial 3
### What I have learned today

### Pertanyaan
**1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.**
**2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?**
**3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.**
**4. Apa perbedaan class component dan functional component?**
**5. Dalam react, apakah perbedaan component dan element?**


### What I did not understand


---
## Tutoriak 6
**1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?**
Otentikasi merupakan proses dalam melakukan verifikasi pada informasi seseorang ketika seseorang mengakses sistem. Otorisasi merupakan proses dalam memeriksa apakah seseorang memiliki izin untuk mengakses bagian sistem yang spesifik.

Konsep tersebut diimplementasi pada package apap.tutorial.pergipergi.security, khususnya pada WebSecurityConfig.java.

Untuk otentikasi terdapat pada bagian:
@Autowired
public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
}

Untuk otorisasi terdapat pada bagian:
http
        .authorizeRequests()
        .antMatchers("/css/**").permitAll()
        .antMatchers("/js/**").permitAll()
        .antMatchers("/user/view-all").hasAuthority("Admin")
        .antMatchers("/user/add").hasAuthority("Admin")
        .antMatchers("/user/delete/**").hasAuthority("Admin")
        .antMatchers("/destinasi/add").hasAuthority("Agen")

**2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.**
BCryptPasswordEncoder merupakan password encoder yang digunakan pada modul spring boot security dalam melakukan decoding, encoding, dan validasi password yang berguna untuk melakukan enkripsi password sehingga data password tidak dapat diketahui. 

Proses yang dilakukannya yaitu BCryptPasswordEncoder mengenkripsi raw password dan menyimpannya pada database. Jika pengguna mengakses kembali, pengguna memasukan password dan BCryptPasswordEncoder akan me-encode password tersebut dan mencocokannya dengan password yang terenkripsi padaa database.

**3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian**
Penyimpanan yang baik dilakukan yaitu hashing. Hal tersebut karena hashing merupakan fungsi satu arah sehingga seseorang tidak dapat mengetahui password yang sudah dihash. Sedangkan encryption merupakan fungsi dua arah sehingga password yang sudah terenkripsi dapat dengan mudah dikembalikan dan password dapat diketahui.

**4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!**
UUID atau universally unique identifier adalah kombinasi 32 karakter yang dibuat secara acak dan unik dengan algoritma tertentu yang berguna dalam mengidentifikasi objek pada internet.

**5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut**
class UserDetailsServiceImpl.java berguna sebagai interface untuk mengambil data yang berkaitan dengan pengguna, khususnya dalam otentikasi dan otorisasi. Class ini harus ada karena terdapat satu method loadUserByUsername() yang berguna untuk melakukan kustomisasi proses pencarian pengguna.

---
## Tutorial 4
###  What I have learned today
Pada tutorial 4 ini saya mempelajari bagaimana view pada springboot dan penggunaan thymeleaf. 

### Pertanyaan
**1. Jelaskan perbedaan th:include dan th:replace!**
th:replace akan mengganti tag yang ada dengan tag yang didefinisikan fragment dan memasukkan konten fragment tersebut.
th:include akan memasukkan fragment ke  dalam bagian tag.

**2. Jelaskan apa fungsi dari th:object!**
th:object berguna untuk menandakan object yang dimaksud dari form yang diisi dan disubmit.Dengan begitu akan memudahkan dalam pembuatan form dan mendefinisikan objek pada form.

**3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**
 "*" akan menggunakan sebagian atribut dari th:object yang sudah sudah ada, sedangkan "$" akan menggunakan seluruh atribut dari th:object.
 *= akan mengevaluasi atribut atau varible dari th:object yang sudah di deklarasi sebelumnya $= akan mengevaluasi keseluruhan atribut atau variabel pada th:object.
 
---
## Tutorial 3
### What I have learned today
Pada tutorial 3 ini, saya mempelajari bagaimana penggunaan database pada project spring dan juga membuat model. Selain itu saya mempelajari bagaimana membuat setter, getter, dan constructor dengan cepat menggunakan library Lombok. Kemudian, saya juga saya mempelajari  saya mempelajari bagaimana penggunaan JPA Repository.

### Pertanyaan
**1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)**
@AllArgsConstructor berguna untuk me-generate default constructor dengan argumen. Constructor ini akan mempunyai semua parameter untuk setiap field.
@NoArgsConstructor berguna untuk me-generate default constructor yang tidak ada argumen. Constructor ini tidak memiliki parameter sama sekali.
@Setter berguna untuk me-generate method Gette secara otomatis pada setiap private filed di dalam class tanpa perlu membuat method setter untuk setiap field dan akan menyingkan kode pada program.
@Getter berguna untuk me-generate method Getter secara otomatis pada setiap private filed di dalam class tanpa perlu membuat method Getter untuk setiap field dan akan menyingkan kode pada program.
@Entity berguna untuk menandakan bahwa class tersebut merupakan entitas.
@Table untuk pembuatan tabel di dalam database dengan properti name yang digunakan untuk memberi nama tabel pada databse.

**2. Pada class TravelAgensiDb, terdapat method findByNoAgensi, apakah kegunaan dari method tersebut?**
Method tersebut berguna sebagai untuk mendapatkan Agensi berdasarkan parameter NoAgensi dari database. findBy merupakan fitur yang disediakan oleh JPA Repository.

**3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn**
@JoinTable akan menyimpan relasi antara dua tabel pada suatu tabel. Sedangkan @JoinColumn akan mendefinisikan kolom pada tabel yang memiliki foreign key dari entitas tabel lain. Dengan begitu @JoinTable akan menyimpan kedua id pada tabel yang berbeda, sedangkan @JoinColumn akan menyimpan id dari tabel lain pada suatu kolom.

**4. Pada class TourGuideModel, digunakan anotasi @JoinColumn pada atribut agensi, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull**
name berguna untuk menentukan nama dari kolom foreign key, referencedColumnName merupakan nama kolom yang direferensikan darii entitas tabel lain, dan nullable apakah kolom foreign key tersebut dapat memiliki nilai null. Perbedaan dari nullable dan @NotNull adalah nullable bisa bernilai true atau false, jika true artinya boleh ada nilai null, jika false artinya tidak boleh null sedangkan @NotNull menandakan bahwa suatu variabel tidak dibolehkan null.

**5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER**
FetchType.LAZY berguna untuk  me-fetch object parent tanpa me-load semua collection object dari child. collection object dari child dapat di-load menggunakan getter method.
CascadeType.ALL menandakan bahwa semua operasi yang dilakukan pada suatu entitas akan mempengaruhi entitas lain yang terkait.
FetchType.EAGER berguna untuk me-fetch object parent sekaligus me-load semua collection object dari child. 

### What I did not understand
Untuk materi tutorial ini saya sudah cukup mengerti

---
## Tutorial 2
### What I have learned today
Pada tutorial 2 ini, saya mempelajari bagaimana proses routing URL pada java spring boot dan bagaimana mengambil data dari query atau path yang dimasukkan oleh pengguna. Selain itu saya mempelajari pembuatan setter dan getter pada class object. Selain itu saya mempelajarin bagaimana menghandle jika pengguna salah memasukkan alamat url.

### Pertanyaan
**Pertanyaan 1: Cobalah untuk menambahkan sebuah Agensi dengan mengakses link berikut: http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa haltersebut dapat terjadi**

Link tidak bisa di akses dan akan muncul error Whitelabel Error Page, dengan error resolving template[add-agensi]. Hal ini terjadi karena file template add-agensi.html untuk menanangani path ini belum dibuat sehingga terjadi error.

**Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat**

@Autowired merupakan implementasi dari konsep dependency injection. Dengan Autowired akan menginject depensi yang ada pada service di controller secara otomatis. Sehingga tidak perlu membuat setter method atau argumen di constructor.

**Pertanyaan 3: Cobalah untuk menambahkan sebuah Agensi dengan mengakses link berikut: http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**

Error akan terjadi saat mengakses link tersebut. hal tersebut terjadi karena pada link tidak ada parameter masukan nomor telepon yang bernilai true sehingga wajib ada. Dengan demikian terjadi error.

**Pertanyaan 4: Jika Papa APAP ingin melihat Travel Agensi dengan nama Papa APAP,link apa yang harus diakses?**
Website ini hanya menyediakan pencarian dengan id Agensi, dengan begitu sesuai dengan input agensi yang telah dilakukan sebelumnya, Papa APAP memiliki idAgensi 1, maka untuk mencarinya dapat melalui link: http://localhost:8080/agensi/view?idAgensi=1


**Pertanyaan 5: Tambahkan 1 contoh Travel Agensi lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/agensi/viewAll , apa yang akan ditampilkan?**

Sertakan juga bukti screenshotmu
Akan menampilkan semua Agensi bersamaan dengan agensi yang ditambah. Agensi yang bertambah sesuai dengan apa yang telah saya masukkan.
![Screen Shot PErtanyaan 5](https://i.ibb.co/mJT4tWY/image.png)

### What I did not understand
Untuk materi tutorial ini saya sudah cukup mengerti

---
## Tutorial 1
### What I have learned today
Pada Tutorial 1, Saya mempelajari bagaimana membuat suatu web menggunakan framework Spring Boot dan juga penggunaan GitHub. Penggunaan Spring Boot yang saya pelajari diantara lain yaitu bagaimana pembuatan project baru, set up Spring Boot, direktori pada project, dan menjalankan program. Pada GitHub, saya mempelajari bagaimana pembuatan repository, menhubungkan repository GitHub dan lokal, pembuatan branch baru, dan melakukan Commit, Push, dan Pull Request.

### Github
**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
Issue Tracker merupakan fitur yang disediakan oleh GitHub untuk menyimpan permasalahan yang ditemukan oleh pengguna dan pengguna juga dapat melihat perkembangan dari masalah tersebut. Dengan begitu masalah yang ada jelas dan pengguna lain juga dapat memantaunya. Issue Tracker dapat membantu para kolaborator dalam menyelesaikan masalah dalam berkolaborasi dan komunikasi antara kolaborator khususnya dalam menangani permasalahan. masalah tersebut seperti dalam menangani permasalahan pada kode program, miskomunikasi antara kolaborator, dan penentuan masalah.

**2. Apa perbedaan dari git merge dan git merge --squash?**
git merge hanya akan menggabungkan setiap commit dari branch yang ada ke master semuanya secara masing-masing dan langsung, sedangkan git merge --squash akan menggabungkan semua file commit yang ada pada branch menjadi satu commit terlebih dahulu baru kemudian digabungkan ke master.

**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**
Dengan VCS akan mudah dalam mengetahui perkembangan secara detail dari pengembangan aplikasi yang sedang dibuat seperti info atau log perubahan-perubahan yang terjadi pada program aplikasi dan file progam dapat disimpan secara online dengan bantuan VCS. Selain itu, VCS juga membantu pengembang dalam mengembangkan aplikasi secara bersama-sama sehingga dapat terhindar dari konflik.

### Spring
**4. Apa itu library & dependency?**
Library adalah sekumpulan file class yang tersimpan pada suatu arsip atau direktori yang memiliki fungsi tertentu dan dapat dipanggil ke dalam program lain sehingga pengembang tidak perlu membuat kode dari dasar. Sedangkan dependency adalah bagian, fungsi, library yang penting dan bagian yang berbeda dari kode sehingga program dapat bekerja. 

**5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**
Maven merupakan project management tool yang sangat bermanfaat dan berbasis POM (Project Object Model) dan biasanya digunakan pada proyek Java. Kita menggunakan maven karen sifatnya yang mudah digunakan karena Maven dapat mendefinisikan proyeknya sendiri dan memiliki struktur proyek sendiri sehingga dapat diakses dari berbagai macam IDE. Selain itu dengan Maven, Dependency dapat dengan mudah dikelola. Bulid Tool lainnya yaitu Ant, Gradle, dan masih banyak build tool lainnya.

**6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Springframework?**
Membuat REST Service untuk situs intitusi edukasi dan membuat sistem managemen perusahaan dan karyawan.

**7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?**
Perbedaannya yaitu @RequestParam mengekstrak value yang dimasukkan dari query string, sedangkan @RequestParam mengekstrak value dari URI path. Keduanya memiliki fungsi yang sama, @PathVariable sebaiknya digunakan ketika setiap value memiliki pathnya masing-masing dan path yang ada pada web dirancang unik untuk menghindari adanya konflik dari path. Sedangkan @RequestParam hanya memiliki satu path saja namun dapat menampilkan sesuai dengan query yang di input.

### What I did not understand
Bagaimana proyek java dengan frame work Spring Boot bekerja secara keseluruhan. Selain itu saya juga masih belum familiar dengan GitHub.

---
### referensi:
https://docs.github.com/en/github/collaborating-with-pull-requests/incorporating-changes-from-a-pull-request/about-pull-request-merges
https://www.upgrad.com/blog/spring-boot-projects-topics-for-beginners/
https://medium.com/@acep.abdurohman90/mengenal-maven-sebagai-java-build-tools-5ba752f75812
https://www.baeldung.com/spring-requestparam-vs-pathvariable
https://en.wikipedia.org/wiki/List_of_build_automation_software
https://software.endy.muhardin.com/java/memahami-dependency-injection/
