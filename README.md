# Tutorial APAP
## Authors
* **Rizky Pratama Nataprawira** - *1906318514* - *B*

---
## Totorial 2
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
![Foto](https://ibb.co/jhfDGXx)

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
