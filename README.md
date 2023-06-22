# Projekt TAW IO2023
## Raport
### 1. Wprowadzenie przedmiotów do systemu

- Nazwa: Metodologie obiektowe, ECTS: 2, Sala: 216, Egzamin: tak,

```
Metoda: POST
Adres zasobu: http://localhost:8080/api/subjects
Nagłówki: Content-Type: application/json
Request Body:
{
"Nazwa": "Metodologie obiektowe",
"ECTS": 2,
"Sala": 216,
"Egzamin": true
}
Odpowiedź:
HTTP Code: 200 OK
Response Body: brak
```

- Nazwa: Testowanie oprogramowania, ECTS: 1, Sala: 216, Egzamin: nie,

```
Request body:
{
"Nazwa": "Testowanie oprogramowania",
"ECTS": 1,
"Sala": 216,
"Egzamin": false
}
```

- Nazwa: Technologie i aplikacje webowe, ECTS: 3, Sala: 208, Egzamin: nie,

```
Request body:
{
"Nazwa": "Technologie i aplikacje webowe",
"ECTS": 3,
"Sala": 208,
"Egzamin": false
}
```

- Nazwa: Zarządzanie projektem informatycznym, ECTS: 2, Sala: 216, Egzamin: nie,

```
Request body:
{
"Nazwa": "Zarządzanie projektem informatycznym",
"ECTS": 2,
"Sala": 216,
"Egzamin": false
}
```

- Nazwa: Zaawansowane technologie bazodanowe, ECTS: 3, Sala: 208, Egzamin: nie,

```
Request body:
{
"Nazwa": "Zaawansowane technologie bazodanowe",
"ECTS": 3,
"Sala": 208,
"Egzamin": false
}
```

- Nazwa: Technologie komponentowe i sieciowe, ECTS: 2, Sala: 208, Egzamin: tak

```
Request body:
{
"Nazwa": "Technologie komponentowe i sieciowe",
"ECTS": 2,
"Sala": 208,
"Egzamin": true
}
```

### 2. Pobranie wszystkich przedmiotów

```
Metoda: GET
Adres zasobu: http://localhost:8080/api/subjects
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body:
[
	{
		"Id": 1,
		"Nazwa": "Metodologie obiektowe",
		"ECTS": 2,
		"Sala": 206,
		"Egzamin": true
	},
	{
		"Id": 2,
		"Nazwa": "Testowanie oprogramowania",
		"ECTS": 1,
		"Sala": 216,
		"Egzamin": false
	},
	{
		"Id": 3,
		"Nazwa": "Technologie i aplikacje webowe",
		"ECTS": 3,
		"Sala": 208,
		"Egzamin": false
	},
	{
		"Id": 4,
		"Nazwa": "Zarządzanie projektem informatycznym",
		"ECTS": 2,
		"Sala": 216,
		"Egzamin": false
	},
	{
		"Id": 5,
		"Nazwa": "Zaawansowane technologie bazodanowe",
		"ECTS": 3,
		"Sala": 208,
		"Egzamin": false
	},
	{
		"Id": 6,
		"Nazwa": "Technologie komponentowe i sieciowe",
		"ECTS": 2,
		"Sala": 208,
		"Egzamin": true
	}
]
```

### 3. Pobranie przedmiotów, które mają egzamin

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects?exam=true
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body:
[
	{
		"Id": 1,
		"Nazwa": "Metodologie obiektowe",
		"ECTS": 2,
		"Sala": 206,
		"Egzamin": true
	},
	{
		"Id": 6,
		"Nazwa": "Technologie komponentowe i sieciowe",
		"ECTS": 2,
		"Sala": 208,
		"Egzamin": true
	}
]
```

### 4. Pobranie przedmiotów, które odbywają się w sali 216

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects?classroom=216
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body:
[
	{
		"Id": 1,
		"Nazwa": "Metodologie obiektowe",
		"ECTS": 2,
		"Sala": 216,
		"Egzamin": true
	},
	{
		"Id": 2,
		"Nazwa": "Testowanie oprogramowania",
		"ECTS": 1,
		"Sala": 216,
		"Egzamin": false
	},
	{
		"Id": 4,
		"Nazwa": "Zarządzanie projektem informatycznym",
		"ECTS": 2,
		"Sala": 216,
		"Egzamin": false
	}
]
```

### 5. Pobranie przedmiotów które nie mają egzaminu i odbywają się w sali 208

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects?exam=false&classroom=208
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body:
[
	{
		"Id": 3,
		"Nazwa": "Technologie i aplikacje webowe",
		"ECTS": 3,
		"Sala": 208,
		"Egzamin": false
	},
	{
		"Id": 5,
		"Nazwa": "Zaawansowane technologie bazodanowe",
		"ECTS": 3,
		"Sala": 208,
		"Egzamin": false
	}
]
```

### 6. Pobranie przedmiotu o identyfikatorze 3

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects/3
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body:
{
	"Id": 3,
	"Nazwa": "Technologie i aplikacje webowe",
	"ECTS": 3,
	"Sala": 208,
	"Egzamin": false
}
```

### 7. Pobranie przedmiotu o identyfikatorze 15

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects/15
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 404 Not Found
Response Body: brak
```

### 8. Usunięcie przedmiotu o identyfikatorze 2

```
Metoda: DELETE
Adres zasobu: localhost:8080/api/subjects/2
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body: brak
```

### 9. Pobranie wszystkich przedmiotów

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body:
[
	{
		"Id": 1,
		"Nazwa": "Metodologie obiektowe",
		"ECTS": 2,
		"Sala": 216,
		"Egzamin": true
	},
	{
		"Id": 3,
		"Nazwa": "Technologie i aplikacje webowe",
		"ECTS": 3,
		"Sala": 208,
		"Egzamin": false
	},
	{
		"Id": 4,
		"Nazwa": "Zarządzanie projektem informatycznym",
		"ECTS": 2,
		"Sala": 216,
		"Egzamin": false
	},
	{
		"Id": 5,
		"Nazwa": "Zaawansowane technologie bazodanowe",
		"ECTS": 3,
		"Sala": 208,
		"Egzamin": false
	},
	{
		"Id": 6,
		"Nazwa": "Technologie komponentowe i sieciowe",
		"ECTS": 2,
		"Sala": 208,
		"Egzamin": true
	}
]
```

### 10. Usunięcie wszystkich przedmiotów

```
Metoda: DELETE
Adres zasobu: localhost:8080/api/subjects
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body: brak
```

### 11. Pobranie wszystkich przedmiotów

```
Metoda: GET
Adres zasobu: localhost:8080/api/subjects
Nagłówki: Content-Type: application/json
Request Body: brak
Odpowiedź:
HTTP Code: 200 OK
Response Body: []
```
