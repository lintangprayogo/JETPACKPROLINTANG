package com.lintang.jetpackprolintang.base.utils

import com.lintang.jetpackprolintang.data.Movie
import com.lintang.jetpackprolintang.data.Series

open class DataDummy {


    companion object {

        fun generateMovie(): List<Movie> {
            val movies = mutableListOf<Movie>()
            movies.add(
                Movie(
                    "419704", "Ad Astra", 6.0, "2019-09-17",
                    "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg", "/p3TCqUDoVsrIm8fHK9KOTfWnDjZ.jpg",
                    "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown."
                )
            )
            movies.add(
                Movie(
                    "181812", "Star Wars: The Rise of Skywalker", 6.7, "2019-12-18",
                    "/db32LaOibwEliAmSL2jjDF6oDdj.jpg", "/p3TCqUDoVsrIm8fHK9KOTfWnDjZ.jpg",
                    "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.."
                )
            )

            movies.add(
                Movie(
                    "449924", "Ip Man 4: The Finale", 6.3, "2019-12-20",
                    "/2MwpeDrI7RbgD6bipT31kpMZe9u.jpg", "/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg",
                    "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year."
                )
            )
            movies.add(
                Movie(
                    "181813", "Knives Out", 7.9, "2019-11-27",
                    "/pThyQovXQrw2m0s9x82twj48Jq4.jpg", "/AbRYlvwAKHs0YuyNO6NX9ofq4l6.jpg",
                    "When renowned crime novelist Harlan Thrombey is found dead at his estate just after his 85th birthday, the inquisitive and debonair Detective Benoit Blanc is mysteriously enlisted to investigate. From Harlan's dysfunctional family to his devoted staff, Blanc sifts through a web of red herrings and self-serving lies to uncover the truth behind Harlan's untimely death."
                )
            )

            movies.add(
                Movie(
                    "181819", "Joker", 8.3, "2019-10-02",
                    "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                    "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure."
                )
            )

            movies.add(
                Movie(
                    "419703", "Frozen II", 7.0, "2019-11-20",
                    "/pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg", "/xJWPZIYOEFIjZpBL7SVBGnzRYXp.jpg",
                    "lsa, Anna, Kristoff and Olaf head far into the forest to learn the truth about an ancient mystery of their kingdom."
                )
            )
            movies.add(
                Movie(
                    "181832", "Zombieland: Double Tap", 7.1, "2019-10-09",
                    "/dtRbVsUb5O12WWO54SRpiMtHKC0.jpg", "/3ghImmHdp4RnC3UkL6hpLayclnb.jpg",
                    "Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family."
                )
            )

            movies.add(
                Movie(
                    "181912", "Gundala", 5.7, "2019-08-29",
                    "/eU0orGizEpOli4wtN8HtfOOJDlA.jpg", "/mlaX4c2M6usnhXHG5sYJcKVXflA.jpg",
                    "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year."
                )
            )
            movies.add(
                Movie(
                    "181612", "6 Underground", 6.3, "2019-11-27",
                    "/lnWkyG3LLgbbrIEeyl5mK5VRFe4.jpg", "/eFw5YSorHidsajLTayo1noueIxI.jpg",
                    "After faking his death, a tech billionaire recruits a team of international operatives for a bold and bloody mission to take down a brutal dictato"
                )
            )

            movies.add(
                Movie(
                    "181852", "Once Upon a Time… in Hollywood", 7.5, "2019-07-25",
                    "/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg", "/c6YyKddg8iVDYRRVZLDEd3m22RI.jpg",
                    "Los Angeles, 1969. TV star Rick Dalton, a struggling actor specializing in westerns, and stuntman Cliff Booth, his best friend, try to survive in a constantly changing movie industry. Dalton is the neighbor of the young and promising actress and model Sharon Tate, who has just married the prestigious Polish director Roman Polanski…"
                )
            )
            return movies
        }

        fun generateSeries(): List<Series> {
            val serieses = mutableListOf<Series>()
            serieses.add(
                Series(
                    "82856", "The Mandalorian", 7.9, "2019-11-12",
                    "/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg", "/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg",
                    "any perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown."
                )
            )

            serieses.add(
                Series(
                    "71912", "The Witcher", 8.2, "2019-11-12",
                    "/zrPpUlehQaBf8YX2NrVrKK8IEpf.jpg", "/bKETHQDD3QoIRTMOP4dfKwisL3g.jpg",
                    "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts."
                )
            )
            serieses.add(
                Series(
                    "60625", "Rick and Morty", 8.6, "2019-11-12",
                    "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg", "/mzzHr6g1yvZ05Mc7hNj3tUdy2bM.jpg",
                    "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.\""
                )
            )

            serieses.add(
                Series(
                    "1412", "Arrow", 5.8, "2012-10-10",
                    "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg", "/dXTyVDTIgeByvUOUEiHjbi8xX9A.jpg",
                    "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
                )
            )
            serieses.add(
                Series(
                    "60735", "The Flash", 6.8, "2014-10-07",
                    "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
                )
            )
            serieses.add(
                Series(
                    "44217", "Vikings", 7.5, "2013-03-03",
                    "/ff1zhqvwfS5HvRNcA5UFrH0PA2q.jpg", "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg",
                    "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors."
                )
            )

            serieses.add(
                Series(
                    "93149", "Plunderer", 0.0, "2020-01-08",
                    "/cp1iGqNNy5JRhWbpP3qoANgz1gV.jpg", "/7BP3aJUCk8Iv20YFAqHcbXpTMwR.jpg",
                    "In a post-apocalyptic world dominated by the so-called \\\"Numbers,\\\" each human will have their identity branded with their own \\\"Count,\\\" which could define any number related to their life. May it be one's walked distance or amount of compliments given to them by others, this Count could lead them to the abyss when it has dropped to zero.\\n\\nIn the year 305 of the Alcian calendar, Hina has inherited a mission from her Mother, whose Count has depreciated to zero, to search for the Legendary Red Baron. In her adventure, she meets a half-masked swordsman named Licht who tries to hide his identity, as he is known as a degenerate for having an incredibly low Count."
                )
            )


            serieses.add(
                Series(
                    "57243", "Doctor Who", 7.0, "2005-03-26",
                    "/cDDb7WA2i7cENhkEEjXEDrXGyNL.jpg", "/mQ9yeCuofNatSyErUKAPD1uOq8Q.jpg",
                    "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel. The Doctor saves planets for a living—more of a hobby actually, and the Doctor's very, very good at it."
                )
            )
            serieses.add(
                Series(
                    "78191", "You", 7.6, "2018-09-09",
                    "/9qZUrhcFVI9MNznVJxdfcrmifof.jpg", "/yA2WBBIcKSsmOyYzlbE9y4r9wua.jpg",
                    "When a brilliant bookstore manager crosses paths with an aspiring writer, he uses the internet and social media to gather the most intimate of details and get close to her. A charming and awkward crush quickly becomes obsession as he quietly and strategically removes every obstacle - and person - in his way."
                )
            )

            serieses.add(
                Series(
                    "2734", "Supernatural", 7.4, "2005-09-13",
                    "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg", "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg",
                    "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
                )
            )

            return serieses
        }

        fun findMovie(id: String): Movie? {
            for (data: Movie in generateMovie()) {
                if (data.id.equals(id)) {
                    return data
                }
            }
            return null
        }

        fun findSeries(id: String): Series? {
            for (data: Series in generateSeries()) {
                if (data.id.equals(id)) {
                    return data
                }
            }
            return null
        }
    }
}