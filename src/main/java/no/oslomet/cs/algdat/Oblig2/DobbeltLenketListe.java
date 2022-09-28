package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;


    }

    public DobbeltLenketListe(T[] a) {

        // sjekker om tabellen er en null tabell, kaster exception.
        if (a == null) {
            throw new NullPointerException();
        }

        //Finner første ikke null element og legger den som hode.
        if (a.length > 0) {
            int i = 0;
            for (; i < a.length; i++) {
                if (a[i] != null) {
                    hode = new Node<>(a[i]);
                    antall++;
                    break;
                }
            }

            // lager hale som peker på sammen element som hode, bytter halet ved neste non null element.
            hale = hode;
            if (hode != null) {
                i++;
                // lager resten av listen, bytter på hale pekeren ved hvert nytt element.
                for (; i < a.length; i++) {
                    if (a[i] != null) {
                        hale.neste = new Node<>(a[i], hale, null);
                        hale = hale.neste;
                        antall++;
                    }
                }
            }
        }


    }

    public Liste<T> subliste(int fra, int til) {
        fraTilKontroll(antall, fra, til);
        Liste<T> subListe = new DobbeltLenketListe<>();
        int lengde = til - fra;
        if (lengde < 1) {
            return subListe;
        }
        Node<T> hjelpeNode = finnNode(fra);
        while (lengde > 0) {
            subListe.leggInn(hjelpeNode.verdi);
            hjelpeNode = hjelpeNode.neste;
            lengde--;
        }
        return subListe;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if (hode == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        //Sjekker om verdien som skal settes inn ikke er null;
        Objects.requireNonNull(verdi);
        Node<T> NyttNode = new Node<>(verdi);
        // sjekker om listen er helt tom, da peker hode og halle til den nye noden, antall endringer og antall noder øker med 1.
        if (hode == null && hale == null && antall == 0) {
            hode = NyttNode;
            hale = NyttNode;
            endringer++;
            antall++;
            return true;
        }
        // hvis listen ikke er tom da er halen verdien før den som settes inn, bytter hale pekere til den nye noden og setter halen til nye node.
        else {
            NyttNode.forrige = hale;
            hale.neste = NyttNode;
            hale = NyttNode;
            endringer++;
            antall++;
            return true;
        }

    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    private Node<T> finnNode(int indeks) {
        //sjekker om indeks finnes i listen, returnerer false hvis ikke.
        indeksKontroll(indeks, false);
        Node<T> midlertidig;

        //hvis indeks er mindre enn liste/2 starter fra hode og setter hode til midlertidig node og setter pekeren til midlertidig.neste i hver iterasjon. stopper loopen på indeks.
        if (indeks < antall / 2) {
            midlertidig = hode;
            for (int i = 0; i < indeks; i++) {
                midlertidig = midlertidig.neste;
            }
            return midlertidig;
        }
        // Hvis indeks er større enn liste/2 starter fra hale og setter hale til midlertidig node og setter pekeren til midlertidig.forrige i hver iterasjon. stopper loopen ved indeks.
        else {
            midlertidig = hale;
            for (int i = antall-1; i > indeks; i--) {
                midlertidig = midlertidig.forrige;
            }
            return midlertidig;
        }
    }

    @Override
    public T hent(int indeks) {
        Node<T> midlertidig = finnNode(indeks);
        return midlertidig.verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    private void fraTilKontroll(int tabellLengde, int fra, int til) {
        if (fra < 0 || til > tabellLengde) {
            throw new IndexOutOfBoundsException();
        }
        if (fra >= til) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi);
        Node<T> Midlertidig = finnNode(indeks);

        T gammelVerdi = Midlertidig.verdi;
        endringer++;

        Midlertidig.verdi = nyverdi;
        return gammelVerdi;
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        //Setter en midlertidig node som hode for å kunne traversere gjennom listen. lager stringbuilder.
        Node<T> midlertidig = hode;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        //sjekker om listen er tom og returnerer tom string hvis den er.
        if (tom()) {
            sb.append("]");
            return sb.toString();
        }
        // Traverserer gjennom listen, bytter peker til neste nodet i hver iterasjon og appender verdien deres, setter komma i mellom hver verdi.
        else {
            sb.append(midlertidig.verdi);
            midlertidig = midlertidig.neste;
            while (midlertidig != null) {
                sb.append(",");
                sb.append(midlertidig.verdi);
                midlertidig = midlertidig.neste;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String omvendtString() {
        Node<T> midlertidig = hale;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //sjekker om listen er tom og returnerer tom string hvis den er.
        if (tom()) {
            sb.append("]");
            return sb.toString();
        }
        //traverserer gjennom listen baklengs, noden peker mot forrige node i hver iterasjon og appender verdien.
        else {
            sb.append(midlertidig.verdi);
            midlertidig = midlertidig.forrige;
            while (midlertidig != null) {
                sb.append(",");
                sb.append(midlertidig.verdi);
                midlertidig = midlertidig.forrige;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }


}

// class DobbeltLenketListe


