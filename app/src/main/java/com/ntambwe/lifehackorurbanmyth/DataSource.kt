

package com.ntambwe.lifehackorurbanmyth

/**
 * Data class representing a flashcard question
 */
data class Flashcard(
    val statement: String,
    val isHack: Boolean,
    val explanation: String
)

/**
 * Provides the list of flashcard questions
 */
object DataSource {
    fun getQuestions(): List<Flashcard> {
        return listOf(
            Flashcard(
                "Drinking water first thing in the morning boosts your metabolism.",
                true,
                "HACK - Drinking water in the morning helps kickstart metabolism."
            ),
            Flashcard(
                "You only use 10% of your brain.",
                false,
                "MYTH - Brain scans show we use virtually all parts of the brain."
            ),
            Flashcard(
                "Chewing gum helps you focus and reduces stress.",
                true,
                "HACK - Studies show chewing gum can improve concentration."
            ),
            Flashcard(
                "Eating carrots improves your night vision significantly.",
                false,
                "MYTH - Carrots help maintain normal vision but won't give super night vision."
            ),
            Flashcard(
                "The Pomodoro technique improves productivity.",
                true,
                "HACK - The Pomodoro technique is a well-known productivity method."
            ),
            Flashcard(
                "You lose most body heat through your head.",
                false,
                "MYTH - Heat loss is proportional to the body surface area exposed."
            ),
            Flashcard(
                "Writing down your goals makes you more likely to achieve them.",
                true,
                "HACK - Research shows written goals increase success rate."
            ),
            Flashcard(
                "Sugar causes hyperactivity in children.",
                false,
                "MYTH - Multiple studies found no link between sugar and hyperactivity."
            ),
            Flashcard(
                "The 2-minute rule helps reduce procrastination.",
                true,
                "HACK - If a task takes less than 2 minutes, do it now."
            ),
            Flashcard(
                "Cracking your knuckles causes arthritis.",
                false,
                "MYTH - No scientific evidence links knuckle cracking to arthritis."
            )
        )
    }
}