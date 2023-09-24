package dev.milzipmoza.unknown

interface DomainEvent

interface DomainEventPublishable<T : DomainEvent> {

    fun getEvents(): Collection<T>

    fun clearEvents()
}

inline fun <T : DomainEvent> DomainEventPublishable<T>.forEachEvent(action: (T) -> Unit): Unit {
    for (event in getEvents()) action(event)
}