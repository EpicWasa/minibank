<template>
    <v-card
            class="mx-auto my-6"
            max-width="350"
            outlined
    >
        <v-list-item three-line>
            <v-list-item-content >
                <v-list-item-title >{{card.name}}</v-list-item-title>
                <v-list-item-subtitle>Card number: {{card.number}}</v-list-item-subtitle>
                <v-list-item-subtitle>Expiration Date: {{card.expirationDate}}</v-list-item-subtitle>
                <v-list-item-subtitle>Expiration Date: {{card.creationDate}}</v-list-item-subtitle>
                <v-list-item-subtitle>Account Name: {{card.account.name}}</v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>

    </v-card>
</template>

<script>
    export default {
        props: ['card'],
        data() {
            return {

            }
        },

    }
</script>

<style>

</style>