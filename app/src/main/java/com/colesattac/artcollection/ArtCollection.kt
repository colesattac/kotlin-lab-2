package com.colesattac.artcollection

fun getArtCollection(): List<ArtworkItem> {
    return listOf(
        ArtworkItem(
            title = "Американская готика",
            imageResId = R.drawable.americangothic,
            author = "Грант Вуд",
            year = "1930",
            detailedInfo = "Картина Гранта Вуда, находящаяся в коллекции Чикагского института искусств."
        ),
        ArtworkItem(
            title = "Урок анатомии доктора Тульпа",
            imageResId = R.drawable.anatomylesson,
            author = "Рембрандт ван Рейн",
            year = "1632",
            detailedInfo = "Картина Рембрандта маслом на холсте, хранящаяся в музее Маурицхёйс в Гааге, Нидерланды."
        ),
        ArtworkItem(
            title = "Рождение Венеры",
            imageResId = R.drawable.birthofvenus,
            author = "Сандро Боттичелли",
            year = "ок. 1484–1486",
            detailedInfo = "Картина итальянского художника Сандро Боттичелли, предположительно написанная в середине 1480-х годов."
        ),
        ArtworkItem(
            title = "Девушка с жемчужной серёжкой",
            imageResId = R.drawable.girlwithapearlearring,
            author = "Ян Вермеер",
            year = "ок. 1665",
            detailedInfo = "Картина маслом голландского художника золотого века Яна Вермеера."
        ),
        ArtworkItem(
            title = "Герника",
            imageResId = R.drawable.guernica,
            author = "Пабло Пикассо",
            year = "1937",
            detailedInfo = "Большая картина маслом на холсте, написанная в 1937 году испанским художником Пабло Пикассо."
        ),
        ArtworkItem(
            title = "Менины",
            imageResId = R.drawable.lasmeninas,
            author = "Диего Веласкес",
            year = "1656",
            detailedInfo = "Картина 1656 года, хранящаяся в музее Прадо в Мадриде, написанная Диего Веласкесом, ведущим художником испанского золотого века."
        ),
        ArtworkItem(
            title = "Мона Лиза",
            imageResId = R.drawable.monalisa,
            author = "Леонардо да Винчи",
            year = "1503–1506",
            detailedInfo = "Портрет в половину роста, написанный итальянским художником Леонардо да Винчи."
        ),
        ArtworkItem(
            title = "Постоянство памяти",
            imageResId = R.drawable.persistenceofmemory,
            author = "Сальвадор Дали",
            year = "1931",
            detailedInfo = "Картина 1931 года художника Сальвадора Дали и одно из самых узнаваемых произведений сюрреализма."
        ),
        ArtworkItem(
            title = "Звёздная ночь",
            imageResId = R.drawable.starrynight,
            author = "Винсент ван Гог",
            year = "1889",
            detailedInfo = "Картина маслом на холсте голландского художника-постимпрессиониста Винсента ван Гога."
        ),
        ArtworkItem(
            title = "Крик",
            imageResId = R.drawable.thescream,
            author = "Эдвард Мунк",
            year = "1893",
            detailedInfo = "Знаменитое произведение искусства норвежского художника Эдварда Мунка."
        )
    )
}
