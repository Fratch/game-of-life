# Game of Life
Implementazione del Game of Life di John Conway in Java per il progetto di Programmazione Avanzata

<!-- ABOUT THE PROJECT -->
## Consegna

Il Gioco della vita (Game of Life in inglese, noto anche solo come Life) è un modello sviluppato dal matematico inglese John Conway sul finire degli anni sessanta. Il Gioco della vita è un esempio di automa cellulare: il suo scopo è quello di mostrare come comportamenti simili alla vita possano emergere da regole semplici e interazioni a molti corpi, principio che è alla base dell'ecobiologia, la quale si rifà anche alla teoria della complessità. Del gioco sono poi state sviluppate versioni con differenti topologie, ad esempio tridimensionali, differenti regole biologiche, e differenti tipi di cellule.

L’obiettivo del progetto è quello di sviluppare il prototipo di un’applicazione Java che consenta di visualizzare l’evoluzione di una data configurazione.

L’applicazione, che dovrà seguire il pattern MVC, dovrà fornire le seguenti componenti:
* Un modello che mette a disposizioni interfacce e classi che descrivono i diversi concetti di Life. Nel modello dovranno essere rappresentati i seguenti concetti (rappresentati mediante interfacce):
* Cellula, rappresenta la singola cellula nel campo;
* Campo, aggrega le cellule secondo uno schema generico (la posizione delle cellule potrebbe essere parametrizzata in modo da considerare diverse tipologie di campi e di coordinate);
* Regola,  è un’interfaccia funzionale con un singolo metodo che, ricevuto in input lo stato della cella corrente e lo stato delle sue vicine, restituisce il nuovo stato della cella. 
* Un controller che permette di gestire l’evoluzione del sistema nonché la possibiltà di caricare da file la configurazione della griglia/campo.
* Una vista che permette di visualizzare l’evoluzione del sistema.

In particolare le interfacce e le classi definite nel modello dovranno garantire (per quanto possibile) estensibilità per gestire eventuali varianti del gioco. 

Tutte le classi sviluppate devono far parte del package:

it.unicam.cs.pa.jlife097988<matricola> 

La consegna del progetto dovrà essere fatta attraverso caricando un archivio in formato .zip, .tgz o .tar.gz denominato <Cognome><Nome><Matricola> con una singola cartella anch’essa denominata <Cognome><Nome><Matricola> contenente:
Un progetto Gradle per il building dell’applicazione (verificare che ‘gradle build’ e ‘gradle run’ funzionino correttamente!);
Una relazione contenente:
La descrizione delle funzionalità implementate
La descrizione delle classi ed interfacce sviluppate con le responsabilità associate ad ognuna di queste;
La descrizione dei test sviluppati per verificare il corretto comportamento del codice
La descrizione dei meccanismi messi a disposizione per poter integrare nuove funzionalità.

Nella valutazione del progetto verranno considerate:
* Definizione delle responsabilità delle classi	("Nello sviluppo del progetto sono state individuate le seguenti responsabilità: Nome della responsabilità, nome dell'attore, responsabilità associata all'attore, classi che implementano quelle funzionalità")
* Metodi coerenti con le responsabilità	
* Principi SOLID rispettati	
* Estendibilità del progetto	
* Pulizia/Stile del codice	
* Efficienza	
* Uso degli strumenti e metodologie viste durante il corso	
* Numero di test e loro efficacia	
* Relazione (Scrittura)

<!-- AVVERTENZE -->
### CONSEGNE CHE NON RISPETTANO LA SPECIFICA NON VERRANNO VALUTATE!

### ESISTONO DIVERSE IMPLEMENTAZIONI DI LIFE IN JAVA: RICORDO CHE L’USO DI CODICE COPIATO E’ CONSIDERATA UNA VIOLAZIONE GRAVE!

