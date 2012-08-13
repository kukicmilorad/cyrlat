cyrlat
======

Convertor for text between latin and Serbian Cyrillic text.

Here are some examples of conversion between cyrillic and latin text:

####Conversion from latin text to cyrillic text:
```
String latinText = "Latin text";
String cyrText = CyrillicLatinConverter.latinToCyrillic(latinText);
```

####Conversion from cyrillic text to latin text:
```
String cyrText = "\u0409\u0438\u0459\u0430\u043D\u0430";
String latinText = CyrillicLatinConverter.cyrilicToLatin(cyrText);
```