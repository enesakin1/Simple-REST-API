# Simple-REST-API

Simple REST API that has written by using Java/Spring Boot.

## Usage

### Post by Entity

```
api/{EntityName}/save
```

>  Json Example
```
{
	"name":"Enes",
	"lastName":"Akin",
	"email":"enesakin@gmail.com",
	"birth":"1960-07-21"
}
```

### Put by Array of Entities

```
api/{EntityName}/update
```

>  Json Example
```
[
		{
			"departmentId": 2,
			"name": "IT"
		}
]
```

### Get by ID

```
api/{EntityName}/get/{ID}
```

### Delete by ID

```
api/{EntityName}/delete/{ID}
```
### Assign Worker to Department by Put

```
api/department/{ID}/worker/{ID}
```

## Database relationship
![DB](https://www.linkpicture.com/q/db_4.png)
