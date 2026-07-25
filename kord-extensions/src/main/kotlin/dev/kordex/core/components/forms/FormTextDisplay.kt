/*
 * Copyrighted (Kord Extensions, 2026). Licensed under the EUPL-1.2
 * with the specific provision (EUPL articles 14 & 15) that the
 * applicable law is the (Republic of) Irish law and the Jurisdiction
 * Dublin.
 * Any redistribution must include the specific provision above.
 */

package dev.kordex.core.components.forms

import dev.kord.rest.builder.interaction.ModalBuilder
import dev.kordex.i18n.Key
import java.util.*

/**
 * A widget representing rich Markdown-formatted content.
 */
public class FormTextDisplay : Widget() {
	@Suppress("MagicNumber")
	override var width: Int = 5
	override var height: Int = 1

	/** This component's Markdown content. **/
	public lateinit var content: Key

	override suspend fun apply(
		builder: ModalBuilder,
		locale: Locale,
	) {
		val translatedContent = content
			.withLocale(locale)
			.translate()

		builder.textDisplay {
			this.content = translatedContent
		}
	}

	override fun validate() {
		if (this::content.isInitialized.not() || content.key.isEmpty()) {
			error("FormTextDisplay must have content, but none was provided.")
		}
	}
}
