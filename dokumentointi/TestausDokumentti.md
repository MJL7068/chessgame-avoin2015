##Testausdokumentti

Automaattisen testauksen pääpisteenä oli jokaisen nappulan oikean liikkumisen varmistaminen. Eri tyyppisillä nappuloilla on erilaisia sääntöjä liikkumisen suhteen ja testauksen tuli varmistaa ettei sääntöjä rikota eikä nappuloita voida siirtää väärin. Lisäksi tuli varmistaa, etteivät nappulat kykene liikkumaan toistensa yli (ratsua lukuunottamatta). Tämän lisäksi sotilaan liike vaihtelee sen sijainnin mukaan ja sen mukaan onko se hyökkäämässä vihollisen kimppuun. Näiden sääntöjen ohjelmointi oli yksi tämän projektin suurimmista haasteista, minkä takia niiden testaaminen oli välttämätöntä.

Nappuloiden luokille olivat tyypillisiä testit, jotka varmistivat, että nappulan palauttama lista eri liikevaihtoehdoista oli oikea eri tilanteissa. Testit esimerkiksi paljastivat sen, että kuninkaan liikuttaminen vasempaan tai oikeaan reunaan sai aikaan ohjelman kaatumisen, koska liikemahdollisuudet laskeva algoritmi ei ollut varautunut siihen että kuningas liikutettaisiin reunaan (kuningashan aloittaa keskeltä). Testien tuli myös varmistaa että nappulat voivat liikkua niihin ruuduille, joilla on vastustajan nappula ja tuhota ne.

Toinen automaattisen testauksen kohde oli nappuloita säilyttävä luokka Pieces. Luokan tuli pystyä luomaan kaikki pelin alkutilanteessa olevat nappulat oikeille paikoille. Lisäksi luokan piti pystyä luomaan muitakin pelitilanteita ladatun tiedon pohjalta. Nappuloiden paikat oli tallennettaessa tallennettu String-muuttujaan Feyn-Edwardsin-notaation mukaan. Lisäksi testien tuli varmistaa että Pieces kykeni palauttamaan etsityt nappulat sijainnin perusteella oikein.

Graafinen käyttöliittymä jäi käsin testattavaksi. Ajoin ohjelmaa nähdäkseni, että kaikki nappulat piirtyvät oikein ruudulle ja että muutkin pelin tiedot näkyvät oikein. Käyttöliittymä myös paljasti tilanteet, jossa nappuloiden liikkumismahdollisuudet oli ohjelmoitu väärin, joka mahdollisti niiden korjauksen.

En pystynyt testaamaan isoa osaa Board-luokan metodeista, koska ne vaativat käyttöliittymän päivittämistä. Tämä sai testit rikkoutumaan, sillä käyttöliittymän luonti ei onnistunut testin aikana. Tämän takia jouduin testaamaan käsin monia vuorojen toimintaan liittyviä asioita sekä shakkilanteisiin liittyvät asiat. Graafinen käyttöliittymä paljasti hyvin selkeästi aina kun ohjelma ei toiminut odotetulla tavalla. Pystyin kuitenkin testaamaan sen, että Boardiin säilytettyjä muuttujia pystyttiin muuttamaan oikein ja että ne palauttivat oikeat arvot.

Käsin testaamisen teki helpommaksi mahdollisuus resetoida peli ja tallentaa tietty pelitilanne.
