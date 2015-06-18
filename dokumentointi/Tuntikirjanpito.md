Tuntikirjanpito:

8.5.2015
n. 1-2 tuntia, käytetty gitin käytön oppimiseen ja projektin lisäämiseen sinne.

9.5.2015
1 tunti, lisää harjoittelua gitin kanssa.

10.5.2015
n. 15min, kirjoitin alustavan aihemäärittelyn.

15.5.2015
2 tuntia, piirsin määrittelyvaiheen luokkakaavion, aloitin ohjelmoinnin ja tein pääluokat ja lisäsin toiminnallisuuden jolla voi siirtää ohjelman luomia nappuloita tekstipohjaisen käyttöliittymän avulla.

17.5.2015
n. 15 min, piirsin määrittelyvaiheen luokkakaavion.
40 min, tein muillekin nappuloille omat luokat ja tein lisää testejä.

21.5.2015
1 tunti, kirjoitin lisää testejä ja tein pit-kansion.

24.5.2015
n. 2,5 tuntia, aloitin tekemääm graafista käyttöliittymää.

27.5.2015
n. 2,5 tuntia, muokkasin käyttöliittymää ja kirjoitin lisää testejä.

28.5.2015
n. 3 tuntia, muokkasin käyttöliittymää. Nyt nappuloita voi liikuttaa klikkailemalla niitä.

28.5.2015
n. 2 tuntia, lisää ohjelmointia ja lisää testejä.

1.6.2015
n. 5 tuntia. Jaoin graafisen käyttöliittymän komponentit, shakkilaudan ja siihen kuuluvat ruudut, omiin luokkiinsa. Lisäksi muokkasin toiminnallisuutta siten, että ohjelman saadessa komennon siirtää nappulaa laudalla, se hakee vain sen ruudun, mihin nappula on siirtynyt, ja sen ruudun mistä se on siirtynyt ja päivittää ne.

2.6 2015
6 tuntia. Jokainen Piece-yläluokan perivä luokka toteuttaa metodin returnPossibleSquares(), joka palauttaa listan ruuduista, joihin kyseinen nappula pystyy siirtymään ottaen huomioon muiden nappuloiden sijainnin siihen nähden. Klikattaessa nappulaa käyttöliittymällä, maalautuvat ne ruudut, joihin nappula pystyy siirtymään. Kun klikataan nappulan määränpää, onnistuu siirto vain jos uusi ruutu on yksi niistä ruuduista, jotka metodi returnPossibleSquares() on palauttanut. Siirron jälkeen käyttöliittymä päivittyy. Lisäksi aloitin uusien testien kirjoittamisen.

3.6 2015
n. 2 tuntia. Kirjoitin testejä Piece-yläluokan alaluokille.

4.6 2015
n. 3,5 tuntia. Kirjoitin lisää testejä, aloitin JavaDocin tekemisen ja tein luokkakaaviot jotka kuvaavat siirron tapahtumia. Muokkasin myös koodia. Shakkinappuloiden kuvat hain Wikimedia Commonsista. Minulla oli yllättäviä vaikeuksia selvittää minne ohjelman käyttämät kuvat tallennetaan maven-projekteissa, mutta selvisin siitä ohjaajan avulla.

9.6 2015
n. 3 tuntia. Lisää testejä ja ohjelmointia. Nyt ohjelma tunnistaa shakkitilanteen. Jos pelaajan kuningas on uhattuna, pystyy hän tekemään vain sellaisia siirtoja, jotka pelastavat kuninkaan. Ohjelma ei vielä tunnista shakkimattia.

10.6 2015
n. 4 tuntia. Aloitin ohjelmoimaan tallennusmahdollisuutta. Nyt ohjelma pystyy tallentamaan yhden rivin pituisen kuvauksen kaikista laudalla olevista nappuloista. Käyttämäni notaatio muistuttaa Forsyth-Edwardsin notaatiota, mutta siinä on pieniä eroja. En ole vielä päättänyt, mihin pelitilanne tallennetaan. Lisäksi ohjelma kysyy nyt pelin alussa pelaajien nimet. Olen vielä ajatellut toteuttaa toiminnallisuuden, jossa pelaaja pystyy luovuttamaan. Tein myös lisää testejä ja päivitin Javadocia.

11.6 2015
n. 4 tuntia. Nyt peli päättyy kun toinen pelaajista painaa Give up-painiketta. Tilanteessa jossa on shakkimatti mikään pelaajan liikkeistä ei ole sallittu, vaan ainoa vaihtoehto on luovuttaa. Peli ei itse tunnista shakkimattia. Muokkasin myös käyttöliittymää. Nyt siinä näkyy pelaajien syöttämät nimet. Tein myös lisää testejä ja päivitin Javadocia.

Ongelmana testien teossa on se, että Board-luokka päivittää isossa osassa metodejaan käyttöliittymää. Kun yritän ajaa näitä testejä, ohjelma valittaa siitä, ettei käyttöliittymä-oliota ole olemassa, vaikka se onkin luotu. Ohjeiden mukaan käyttöliittymää ei tarvitse testata, mutta tämä aiheuttaa sen että suurintaa osaa Board-luokan metodeista ei ole testattu.

14.6 2015
n. 6 tuntia. Nyt ohjelma pystyy tallentamaan pelitilanteen Stringinä tekstitiedostoon ja lataamaan sen myöhemmin. Ohjelma pystyy pitämään muistissa vain yhtä aikaisempaa pelitilannetta. Lisäksi ohjelmoin uuden alkuruudun, joka mahdollistaa pelaajan nimien syöttämisen ja aikaisemman tallennuksen lataamisen. Tämän lisäksi päivitin Javadocia, kirjoitin rakennekuvauksen ja tein koodikatselmuksen.

15.6 2015
n. 1 tunti. Viimeistelin ohjelmaa demoa varten.

17.6 2015
n. 5 tuntia. Viimeistelin ohjelmaa ja kirjoitin testejä.

18.6 2015
n. 5 tuntia. Tein Javadocin, Checkstylen, testausdokumentin ja viimeistelin testit ja ohjelman. Palautin myös jar-tiedoston.
