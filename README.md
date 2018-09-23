# OOP17-fag

Fight Avenge Guerrilla

## Istruzioni per import su Eclipse

* Clonare la repo `git clone git@bitbucket.org:goffo/oop17-fag.git`
* Assicurarsi di aver installato il plugin `e(fx)clipse` in Eclipse
* Importare il progetto `File -> Import -> Gradle -> Exixsting Gradle Project`
* Attendere la sincronizzazione di tutti i file Gradle

## Setup Gradle

Sono stati adottati tutti i plugin (CheckStyle, PMD, SpotBugs) e per ogni plugin
è stato definito un task per la generazione dei report.

Tutti i report generati sono nella cartella `build/reports`

## Creazione ed esecuzione JAR

Generare il JAR mediante il comando: `./gradlew fatJar`. Il JAR verrà esportato in `build/libs/fag-goffo-0.1.0.jar`
Se durante la fase di gioco si sperimenta una velocità troppo elevata, questo può essere causato da un bug nel framework
__quantum__ (su schede video NVidia questa problematica non è stata riscontrata).  
Eseguire il jar: `java -Dquantum.multithreaded=false -jar fag-goffo-0.1.0.jar`

### CheckStyle task

`./gradlew checkstyleMain` genera il report su `build/reports/checkstyle/main.html`  
`./gradlew checkstyleTest` genera il report su `build/reports/checkstyle/test.html`

### PMD task

`./gradlew pmdMain` genera il report su `build/reports/pmd/main.html`  
`./gradlew pmdTest` genera il report su `build/reports/pmd/test.html`

### SpotBugs task

`./gradlew spotbugsMain` genera il report su `build/reports/spotbugs/main.html`  
`./gradlew spotbugsTest` genera il report su `build/reports/spotbugs/test.html`

## Testing

`./gradlew test` per il running degli Unit test  
`./gradlew check` per tutti i check (test inclusi)

## Known bugs

* Su MAC utilizzando Oracle JDK10, si riscontra una NullPointerException in fase di lancio, ciò è causato da un bug noto
corretto su OpenJDK ma a quanto pare non su OracleJDK. Si sconsiglia di testare su Mac con OracleJDK 10 [https://bugs.openjdk.java.net/browse/JDK-8204604]