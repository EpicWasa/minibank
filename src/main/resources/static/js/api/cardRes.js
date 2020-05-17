import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource);

const cards = Vue.resource('api/cards{/id}');

export default {
    add: card => cards.save({}, card),
    update: card => cards.update({id: card.id}, card),
    remove: id => cards.remove({id})
}