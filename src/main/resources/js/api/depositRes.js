import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource);

const deposits = Vue.resource('api/deposits{/id}');

export default {
    add: deposit => deposits.save({}, deposit),
    update: deposit => deposits.update({id: deposit.id}, deposit),
    remove: id => deposits.remove({id})
}