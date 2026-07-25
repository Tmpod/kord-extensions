/*
 * Copyrighted (Kord Extensions, 2026). Licensed under the EUPL-1.2
 * with the specific provision (EUPL articles 14 & 15) that the
 * applicable law is the (Republic of) Irish law and the Jurisdiction
 * Dublin.
 * Any redistribution must include the specific provision above.
 */

package dev.kordex.core.components.forms

import dev.kord.rest.builder.interaction.ModalBuilder
import java.util.*

/**
 * A component usable inside modal forms.
 */
public abstract class Widget {
	/** How wide this component is, in grid cells. **/
	public abstract var width: Int
		protected set

	/** How tall this component is, in grid cells. **/
	public abstract var height: Int
		protected set

	override fun toString(): String =
		"${this::class.simpleName}@${hashCode()} ($width x $height)"

	/** Function called to apply this component to a Discord form. **/
	public abstract suspend fun apply(builder: ModalBuilder, locale: Locale)

	/** Function called to ensure that this component was set up correctly. **/
	public abstract fun validate()
}
