# Java Sets ve Collections Projesi

Bu proje, Java'da `Set` koleksiyonlarının özelliklerini ve temel set operasyonlarını (Union, Intersection, Difference) kullanarak karmaşık veri yönetimi senaryolarını çözmeyi hedeflemektedir. Ayrıca, metin işleme ve benzersiz kelime bulma gibi yaygın bir görevi de içermektedir.

---

## Proje Hedefleri

Proje, iki ana meydan okumadan oluşmaktadır:

### 1. Set Challenge (Görev Yönetimi)

Şirket içi görev yönetimini simüle eden bir senaryo üzerinden, Set yapılarını kullanarak çalışanların (Ann, Bob, Carol) görevlerini yönetmek ve müdür raporları hazırlamak.

* **Task Eşsizliği:** Bir `Task`'ın eşsizliği, `project` ve `description` alanlarının birleşimi ile belirlenir (`equals()` ve `hashCode()` override edildi).
* **Set Operasyonları:** `TaskData` sınıfı altında görev Set'leri üzerinde **Birleşim (Union)**, **Kesişim (Intersection)** ve **Fark (Difference)** işlemleri gerçekleştirilmiştir.

### 2. String Challenge (Benzersiz Kelime Bulma)

Verilen bir metin bloğu içindeki noktalama işaretlerini temizleyerek, metindeki **benzersiz (unique)** kelimeleri bulmak ve bunları alfabetik olarak sıralamak.

---

## Kurulum ve Çalıştırma

Bu projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları izleyin.

### Önkoşullar

* **Java Geliştirme Kiti (JDK):** Java 17 veya üzeri
* **IDE:** IntelliJ IDEA önerilir.
* **Git:** Projeyi klonlamak için

### Proje Kurulumu

1.  **Projeyi Çatallayın (Fork) ve Klonlayın:**
    ```bash
    git clone [PROJE_GITHUB_URL]
    ```

2.  **Projeyi Açın:**
    IntelliJ IDEA'yı açın ve klonladığınız proje dizinini (genellikle `pom.xml` dosyasının bulunduğu ana dizin) **Import Project** veya **Open** seçeneği ile açın.

3.  **Paket Yapısı:**
    Projeniz aşağıdaki gibi bir yapıya sahip olmalıdır:

    ```
    src/main/java/
    └── org/example/entity/
        ├── Task.java
        ├── TaskData.java
        ├── Priority.java (Enum)
        ├── Status.java (Enum)
        └── StringSet.java
    ```

4.  **Testleri Çalıştırma:**
    Projenin doğru çalıştığını kontrol etmek için `src/test/java/MainTest.java` dosyasındaki JUnit testlerini çalıştırabilirsiniz.

---

## Kullanılan Sınıflar ve Metotlar

### `org.example.entity.TaskData`

Bu sınıf, çalışanların görev Set'lerini (Ann, Bob, Carol, Unassigned) yönetir ve set operasyonlarını uygular.

| Metot | Açıklama |
| :--- | :--- |
| `getTasks(String assignee)` | "ann", "bob", "carol", "all" parametrelerine göre ilgili görev Set'ini döndürür. |
| `getUnion(List<Set<Task>> sets)` | Bir listedeki tüm Set'lerin birleşim kümesini döndürür. |
| `getIntersect(Set<Task> set1, Set<Task> set2)` | İki Set'in kesişim kümesini döndürür. |
| `getDifference(Set<Task> set1, Set<Task> set2)` | İlk Set'ten ikinci Set'teki elemanları çıkararak fark kümesini döndürür. |

### `org.example.entity.Task`

Görevleri temsil eder. **Eşsizlik** kuralı sadece `project` ve `description` alanlarına göre belirlenmiştir.

### `org.example.entity.Priority` ve `org.example.entity.Status`

Görevler için kullanılan basit Enum tipleridir.

### `org.example.entity.StringSet`

Metin işleme challenge'ı için kullanılan static metotları içerir.

| Metot | Açıklama |
| :--- | :--- |
| `findUniqueWords()` | Verilen metin bloğunu temizler, benzersiz kelimeleri bulur ve bunları **alfabetik olarak sıralanmış** bir Set olarak döndürür. |

---

## Sonuçlar ve Raporlama (Set Challenge)

`TaskData` sınıfındaki temel Set operasyonları, müdürünüzün istediği raporlama ihtiyaçlarını karşılamak için kullanılmıştır:

* **Tüm Çalışanların Görevleri:** `getUnion(List.of(annsTasks, bobsTasks, carolsTasks))` metodu ile elde edilir.
* **Atanmamış Görevler:** `unassignedTasks` Set'i kullanılır.
* **Çakışan Görevler:** `getIntersect()` metodu kullanılarak iki çalışan arasındaki kesişimler bulunur ve bunlar tekrar `getUnion()` ile birleştirilerek birden fazla çalışana atanmış görevler ortaya çıkarılır.

---

## String Challenge Sonucu

`StringSet.findUniqueWords()` metodu, sağlanan uzun metin bloğu içindeki noktalama işaretlerini (`.`, `,`, `!`, `?`, `"`) temizledikten sonra, benzersiz kelimeleri bulur ve bir `TreeSet` (veya sıralı Set) kullanarak **alfabetik olarak sıralanmış** bir şekilde sunar.
