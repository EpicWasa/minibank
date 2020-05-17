<template>
    <v-card
            class="mx-auto my-6"
            max-width="344"
            outlined
    >
        <v-list-item three-line>
            <v-list-item-content>
                <div class="overline mb-4">{{account.currency.name}}</div>
                <v-list-item-title class="headline mb-1">{{account.name}}</v-list-item-title>
                <v-list-item-subtitle>{{account.amount}}</v-list-item-subtitle>
                <card-card v-for="card in cards" :card="card"></card-card>
            </v-list-item-content>
            <v-list-item-icon>
                <v-icon>{{wallet}}</v-icon>
            </v-list-item-icon>
        </v-list-item>



    </v-card>

</template>

<script>
    import CardCard from 'components/CardCard.vue'

    export default {
        components: {
            CardCard,
        },
        props:['account', 'cards'],
        data(){
            return{
                wallet: mdiWallet,

            }
        }
    }
    import {mdiWallet} from '@mdi/js'
</script>

<style>


</style>