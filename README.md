# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Muaath Zerouga

# Arbeidsfordeling

Denne oppgaven er levert alene, alle oppgaver er løst av Muaath Zerouga.

# Oppgavebeskrivelse

Oppgave 1)

Laget en dobbetlinket liste basert på tabell a. sjekket om tabell er null og kastet en exception hvis den er. gikk deretter inn i tabellen og hentet første non null verdi
og gjorde den til hode. brukte et midlertidig variabel for å sette pekeren til hode.neste. Loopet gjennom tabellen og satt alle non null verdier i hjelpvariablen.neste; satt til slutt halen.
Laget også metodene antall som returnerte antall noder, og boolean tom som sjekket om hodet er null og returnerte true hvis den var.

Oppgave 2)

Brukte Stringbuilder for å appende alle verdiene i listen. sjekket om listen er tom og appendet en tom parantes hvis den var. Hvis ikke så appendet jeg verdien til hode, appendet en komma og starten en loop.
Loopen startet fra hode.neste og appended alle non null verdiene og satt pekeren til neste repeterte prosessen helt til hode.neste var null.
For omvendt streng brukte jeg samme konsept som oppgave 1.a men startet fra halen og satt pekeren til hale.forrige i hver iterasjon av loopen.

Oppgave 3)

Finn node får en indeks som argument og sjekker om indeksen ligger nærmere hode eller hale og starter basert på det. hvis indeks er nærmere hode så starter vi fra hode og setter pekeren til hode.neste i hver iterasjon
av loopen, vi stopper når int i > indeks, da er hjelpevariablen.neste på korrekt plass og da henter vi ut noden som ligger i denne plassen. Hvis indeks var nærmere halen så repeterte vi samme konsept bare at hjelpevariablen startet på hale
og satt pekeren til hale.forrige helt til int i > indeks, da ble hjelpevariablen.forrige på indeksplassen vi ville ha den i. og da returnerte vi noden som ligger i denne indeksen.
metoden hent kalte bare på finnode og returnerte node.verdi.
I oppdater metoden brukte vi objects.requiresnonnull for å sjekke om verdien vi skulle sette inn var null. Vi hentet den gamle verdien ved bruk av finn nodet og lagret den i et hjelpevariabel, vi byttet gammelverdi med ny verdi som kom inn som argument
og returnerte gammel verdi.
For metoden subliste laget jeg en hjelpemetode for å kontrollere argumentene. laget en ny dobbeltlenketliste ved bruk av konstruktør og kalte på finnnode metoden på fra posisjon og satt den som hode. jeg brukte legginn metoden for å sette inn verdiene basert på lengden til sublisten.
tok lengde -- etter hver innleggelse og satt pekeren til hjelpevariabel.neste i hver while iterasjon.

Oppgave 4)

sjekket først om verdien er null, returnerte -1 hvis den var. brukte deretter et hjelpevariabel og satt den til hode, brukte en for loop for å loope gjennom listen og sammenlignet verdien til hjelpevaribelen med variablen som kommer som argument, når verdien er lik så returnerer vi i som er indeksen til verdien.
hvis verdien ikke er funnet returnerer jeg -1. Bolean indekstil kaller bare på metoden indekstil og returner true dersom indekstil ikke returnerer -1.

Oppgave 5)

Sjekker først om verdien som kommer inn som argument er null, kaster en exception hvis den er. Kontrollerer deretter indeksen og sjekker om den er mindre enn nul eller større enn antall. Sjekker deretter om listen er tom og indeks er null, hvis de er så legger vi noden som eneste i listen, og setter både hode og hale pekerne til dne.
deretter sjekker jeg om indeks er den siste i listen, da bytter jeg hale pekerne og setter den nye noden til hale. gjør det samme om indeks er null og listen ikke er tom, da blir den nye noden til hodet og bytter hode pekerne.Hvis ingen av disse tilfellene er skjer da må ny node legges i midten, da looper vi gjennom listen og setter pekeren til hjelpevariabel.neste
i hver iterasjon. stopper loopen når vi når indeksen og da er hjelpevariabel.neste den indeksen vi skal legge noden i, da setter vi midlertidig.neste til new Node og bytter pekerne til forrige og neste node. Øker antall og endringer med 1.

Oppgave 6)
sjekker om indeksen vi skal fjerne er gyldig ved å kalle indekskontroll. sjekker om indeksen er første i listen, hvis den er bytter vi hode pekerne og setter hode til hode.neste. Sjekker deretter om det finnes elementer etter hode, hvis ikke så blir hode og hale satt til null. Sjekker deretter om indeksen er det siste elementet i listen, hvis den har så bytter vi halen og hale pekerne.
Hvis ikke så ligger deni midten, da looper vi gjennom listen til vi når indeksen vi skal fjerne og bytter pekerne til forrige og neste node. når vi finner indeksen som skal fjernes i hvert tilfelle så lagrer vi verdien i et hjelpevariabel, og returnerer den etter å ha økt endringer og antall med 1.
Metoden boolean fjern bruker samme tankegang som metoden tidligere bare at det vi sjekker for er ikke indeksen men om verdien til noden er den samme som verdien som kommer inn som argument. hvis den er så bytter vi pekere basert på hvor den ligger i listen, til slutt minker vi antall med 1 og returnere verdien som blir fjernet fra listen.

Oppgave 8)

Lager metoden T next() sammenligner iteratorendringer og endringer, kaster exception hvis de ikke er. Deretter sjekker vi om hasnext er false, hvis den er så kaster vi en NoSuchElementException. Metoden iterator() returnerer bare en ny iterator. Metoden dobbeltlenketlisteiterator kaller finnnode med indeks som argument og setter den til "denne". deretter så setter den fjernOK til false, og til slutt setter iteratorenrdinger
til like endringer.   


* Kommentar : 

Oppgave 8 klarte ikke å bestå testen. jeg får en feil på testmetoden i oppgave 8. Klarte ikke å få testen til å fungere. oppgaven fungerte på den gamle testen, men fungerte ikke dersom jeg lastet ned den nye test classen ute på canvas.

 



