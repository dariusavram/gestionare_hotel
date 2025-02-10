# Hotel Management Application

## Descriere
Această aplicație de gestionare a hotelului permite utilizatorilor să efectueze rezervări, să verifice starea camerelor și să gestioneze datele clienților printr-o **interfață grafică intuitivă**.

## Funcționalități
- **Autentificare utilizator** printr-un formular de login (`Login`).
- **Vizualizare și gestionare camere** (`MainScreenCamere`):
  - Camerele pot avea trei stări vizuale (`Verde = Liberă`, `Roșu = Ocupată`, `Galben = În curs de curățare`).
  - Starea camerelor este **salvată într-un fișier** pentru persistență.
- **Rezervare camere** (`Rezervare`):
  - Introducerea detaliilor despre client.
  - Calcularea prețului total.
  - Finalizarea rezervării.
- **Gestionare date clienți** (`Date_Client`):
  - Formulare pentru nume, prenume, email, telefon și CNP.
- **Meniu principal după autentificare** (`afterLogin`):
  - Permite navigarea către rezervări și statusul camerelor.  

## Structura Proiectului

### 1. **Interfața Grafică**
- **`Login`** – formularul de autentificare.
- **`afterLogin`** – meniul principal după login.
- **`MainScreenCamere`** – afișează camerele și starea lor.
- **`Rezervare`** – formularul de rezervare.
- **`Date_Client`** – formular pentru introducerea datelor clientului.  

### 2. **Gestionarea Camerelor**
- Camerele sunt reprezentate ca butoane colorate (`MainScreenCamere`).
- Stările camerelor sunt salvate și încărcate dintr-un fișier `buttonStates.dat`.  

### 3. **Gestionarea Datelor Clienților**
- Datele clientului sunt colectate prin câmpuri de text (`Date_Client`).
- Rezervările sunt finalizate prin butonul `finalizareRezervareButton`.  

## Compilare și Rulare
1. **Asigură-te că ai Java instalat** (versiunea 8+).
2. **Rulează aplicația** dintr-un IDE (IntelliJ, Eclipse) sau din terminal:
   ```sh
   javac Main.java
   java Main
   ```
