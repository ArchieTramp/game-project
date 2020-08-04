let $actions = document.querySelector('.action-window');
let $events = document.querySelector('.event-items');

$actions.addEventListener('click', createEvent);

function createEvent(event)
{
    let target = event.target;

    if (target.dataset.eventmessage)
    {
        let eventMessage = document.createElement('div');
        eventMessage.classList.add('event-item');

        let eventSpan = document.createElement('span');
        eventSpan.textContent = target.textContent;
        eventSpan.style.fontWeight = 'bold';


        eventMessage.textContent = 'Игрок Name совершил действие ';

        switch (target.dataset.eventmessage) {
            case 'aggressive':
                eventMessage.classList.add('aggressive-event');
                break;
            case 'neutral':
                eventMessage.classList.add('neutral-event');
                break;
            case 'positive':
                eventMessage.classList.add('positive-event');
                break;
        }

        $events.insertAdjacentElement('beforeEnd', eventMessage);
        eventMessage.insertAdjacentElement('beforeEnd', eventSpan);
        $events.scrollTop = $events.scrollHeight;
    }
}
