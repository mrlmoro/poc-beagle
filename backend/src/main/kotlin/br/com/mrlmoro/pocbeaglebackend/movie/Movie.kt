package br.com.mrlmoro.pocbeaglebackend.movie

data class Movie(
    val id: String,
    val title: String,
    val synopsis : String,
    val genres: String,
    val durationMinutes: Int,
    val releaseDate: String,
    val imdbUrl: String,
    val bannerUrl: String,
    val likes: Int = 0
)

fun moviesMock() = listOf(
    Movie(
        id = "1",
        title = "Parasita",
        synopsis = "Toda a família de Ki-taek está desempregada, vivendo em um porão sujo e apertado, mas uma obra do acaso faz com que ele comece a dar aulas de inglês a uma garota de família rica. Fascinados com a vida luxuosa destas pessoas, pai, mãe e filhos bolam um plano para se infiltrarem também na família burguesa, um a um. No entanto, os segredos e mentiras necessários à ascensão social custam caro a todos.",
        genres = "Comédia, Drama, Suspense",
        durationMinutes = 132,
        releaseDate = "07/11/2019",
        imdbUrl = "https://www.imdb.com/title/tt6751668/",
        bannerUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fencrypted-tbn2.gstatic.com%2Fimages%3Fq%3Dtbn%3AANd9GcQJmbajoepvv5M8KO0eev1s80qkpthWlbLvWR1L0BsMat307ypG&psig=AOvVaw3Nt8E1U39xXsX8fwKXcxmV&ust=1588364730501000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCJjJ3-79kOkCFQAAAAAdAAAAABAD"
    ),
    Movie(
        id = "2",
        title = "Vingadores: Ultimato",
        synopsis = "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.",
        genres = "Ação, Aventura, Drama",
        durationMinutes = 181,
        releaseDate = "25/04/2019",
        imdbUrl = "https://www.imdb.com/title/tt4154796/",
        bannerUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fencrypted-tbn0.gstatic.com%2Fimages%3Fq%3Dtbn%3AANd9GcQMwtU95JygcmCq4e3XPpL9W0ATjGFoQCQm16dbpIp7BM36B7lH&psig=AOvVaw2Agx8xyxyUn_YoAT2sALaz&ust=1588365793344000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOi7qumBkekCFQAAAAAdAAAAABAD",
        likes = 1 //TODO remove
    ),
    Movie(
        id = "3",
        title = "O Homem Invisível",
        synopsis = "Em O Homem Invisível, quando o ex abusivo de Cecilia (Elisabeth Moss) tira a própria vida e deixa sua fortuna, ela suspeita que a morte dele tenha sido uma farsa. Como uma série de coincidências se torna letal, Cecilia trabalha para provar que está sendo caçada por alguém que ninguém pode ver.",
        genres = "Terror, Mistério, Ficção",
        durationMinutes = 124,
        releaseDate = "27/02/2020",
        imdbUrl = "https://www.imdb.com/title/tt1051906/",
        bannerUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fencrypted-tbn3.gstatic.com%2Fimages%3Fq%3Dtbn%3AANd9GcTUKd00d2a05DH3cw5wGfLojHxsS6guhds8HuhXpUsEiqfSlzWe&psig=AOvVaw3yXAFSGW3X4sglzypsAVvu&ust=1588367192498000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPDZrISHkekCFQAAAAAdAAAAABAD"
    ),
    Movie(
        id = "4",
        title = "Pantera Negra",
        synopsis = "Conheça a história de T'Challa, príncipe do reino de Wakanda, que perde o seu pai e viaja para os Estados Unidos, onde tem contato com os Vingadores. Entre as suas habilidades estão a velocidade, inteligência e os sentidos apurados.",
        genres = "Ação, Aventura, Ficção",
        durationMinutes = 134,
        releaseDate = "15/02/2018",
        imdbUrl = "https://www.imdb.com/title/tt1825683/",
        bannerUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fencrypted-tbn2.gstatic.com%2Fimages%3Fq%3Dtbn%3AANd9GcQarmjVytz3ISRKJNwmxG7o-r4sWWN5VxbPp9qJauK4VvGrKu36&psig=AOvVaw0vlNzRQColfxrNL09O0w6b&ust=1588367262917000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMCvg6aHkekCFQAAAAAdAAAAABAD"
    ),
    Movie(
        id = "5",
        title = "Star Wars - O Império Contra-Ataca",
        synopsis = "Yoda treina Luke Skywalker para ser um cavaleiro Jedi. Han Solo corteja a Princesa Leia enquanto Darth Vader retorna para combater as forças rebeldes que tentam salvar a galáxia.",
        genres = "Ação, Aventura, Fantasia",
        durationMinutes = 124,
        releaseDate = "21/07/1980",
        imdbUrl = "https://www.imdb.com/title/tt0080684/",
        bannerUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPDK1RaURYxdi20dvrq-GrN4fvl2ixhqWhcmMQSjMy7ehtNPq7",
        likes = 2 //TODO Remove
    ),
    Movie(
        id = "6",
        title = "De Volta Para o Futuro",
        synopsis = "Marty McFly, um adolescente de uma pequena cidade californiana, é transportado para a década de 1950 quando a experiência do excêntrico cientista Doc Brown dá errado. Viajando no tempo em um carro modificado, Marty conhece versões jovens de seus pais e precisa fazer com que eles se apaixonem, ou então ele deixará de existir. Para complicar, Marty precisa voltar para casa a tempo de salvar o cientista.",
        genres = "Aventura, Comédia, Ficção",
        durationMinutes = 116,
        releaseDate = "25/12/1985",
        imdbUrl = "https://www.imdb.com/title/tt0088763/",
        bannerUrl = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQbxuP5hlzUHE3gyrWzkXv5OTG5EYcsAKsByP9QG0tqfKNlZJZV",
        likes = 1 //TODO Remove
    )
)