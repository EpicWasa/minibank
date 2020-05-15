<template>
    <v-card
            class="mx-auto"
            max-width="350"
            outlined
    >
        <v-list-item one-line>
            <v-list-item-content>
                <v-list-item-title class="headline mb-1">{{card.number}}</v-list-item-title>

            </v-list-item-content>
            <v-list-item-icon>
                <v-icon>{{payment}}</v-icon>
            </v-list-item-icon>
        </v-list-item>

    </v-card>
</template>

<script>

    export default {
        props:['card'],
        data(){
            return{
                payment: mdiCard,
            }
        }
    }
    import {mdiCard} from '@mdi/js'
</script>

<style>

</style>