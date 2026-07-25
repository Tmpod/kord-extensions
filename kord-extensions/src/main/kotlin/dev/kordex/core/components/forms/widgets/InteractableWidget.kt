/*
 * Copyrighted (Kord Extensions, 2024). Licensed under the EUPL-1.2
 * with the specific provision (EUPL articles 14 & 15) that the
 * applicable law is the (Republic of) Irish law and the Jurisdiction
 * Dublin.
 * Any redistribution must include the specific provision above.
 */

package dev.kordex.core.components.forms.widgets

import dev.kord.rest.builder.component.LabelComponentBuilder
import dev.kord.rest.builder.interaction.ModalBuilder
import dev.kordex.core.components.forms.Widget
import dev.kordex.i18n.Key
import java.util.*

/** Abstract type representing an interactable [Widget]. **/
public abstract class InteractableWidget<T> : Widget() {
	/** The final value stored in this widget, as provided by the user. **/
	public abstract var value: T
		protected set

	/** The Widget's label, displayed on Discord. **/
	public abstract var label: Key
		protected set

	/** An optional description for the Widget. Displayed on Discord. **/
	public abstract var description: Key?
		protected set

	public abstract suspend fun apply(builder: LabelComponentBuilder, locale: Locale)

	public final override suspend fun apply(builder: ModalBuilder, locale: Locale) {
		builder.label(label.withLocale(locale).translate()) {
			apply(this, locale)
		}
	}
}
