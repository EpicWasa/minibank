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
                <v-list-item-subtitle>
                    Sum: {{account.amount}}<br/>
                    CreationDate: {{account.creationDate}}
                </v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>



    </v-card>

</template>

<script>


    export default {

        props:['account'],
        data(){
            return{


            }
        }
    }

</script>

<style>


</style>