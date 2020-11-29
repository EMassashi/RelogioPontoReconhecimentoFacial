# Punch Clock

This project is a simple punch clock that uses facial recognition as ID method. Developed by the student Elton Massashi Takeuchi in the subject of Design and Development of Sowftware, in System Analysis and Development course from Universidade São Francisco (USF).

## Preview
<img src=".\RelogioPonto\src\Images\login_screen.png" width="240"> <img src=".\RelogioPonto\src\Images\register_face.png" width="240"> <img src=".\RelogioPonto\src\Images\recognize_face.png" width="240"> <img src=".\RelogioPonto\src\Images\records.png" width="240">


## Feature
* Uses facial recognition as ID method.
* Detects and register people with the respective data.
* Detects and identify people from the database.

## Installation

- Download and install [JRE 8](https://www.oracle.com/java/technologies/javase-jre8-downloads.html).
- Download and install [JDK 14](https://jdk.java.net/archive/).
- Download [JavaCV 1.5.4](https://github.com/bytedeco/javacv/releases) and extract to the root of the system (example: C:\javacv-bin).
- Clone the repository and create the database schema in [MySQL](https://dev.mysql.com/downloads/) using the [SQL Script file](https://github.com/EMassashi/RelogioPontoReconhecimentoFacial/blob/master/SQL%20Script.sql).
- Open the [project folder](https://github.com/EMassashi/RelogioPontoReconhecimentoFacial/tree/master/RelogioPonto) on the [NetBeans IDE](https://netbeans.apache.org/download/index.html).

## Usage
- Insert admin credentials in the database for the login:

```sql
USE facerecognition

INSERT INTO login (username, password, isadmin)
VALUES ("user", "pass", 1)
```
- Run the project or run the view.Login class file.
- Login with the created credentials.
- Choose the register option from the menu:
<img src=".\RelogioPonto\src\Images\Imagesicons8_Add_User_Group_Woman_Man_25px.png" width="40">
- Fill the information about the person on the right side of the panel.
- Afterwards click or hold down the finish button while the camera on the left side of the panel is recognizing a face (the rectangle on the face means it is recognizing).
- To recognize the person just registered just click on the recognize option from the menu:
<img src=".\RelogioPonto\src\Images\icons8_Facial_Recognition_25px_1.png" width="40">
- If the program works it will have the rectangle on the face of the person in the camera on the left side of the panel and the data of the person on the right side of the panel with the respective labels. If you want to punch the clock just click the OK button if the data matches with the person on the camera.
- To see the records just choose the option from the menu:
<img src=".\RelogioPonto\src\Images\icons8_Folder_25px.png" width="40">
- To edit people data just choose the edit option from the menu:
<img src=".\RelogioPonto\src\Images\icons8_Add_User_Male_20px_2.png" width="40">

## License
[MIT](https://github.com/EMassashi/RelogioPontoReconhecimentoFacial/blob/master/LICENSE.txt)
