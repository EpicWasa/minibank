<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">New Card</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline" >New Card</span>
                </v-card-title>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12">
                                <v-text-field label="CardName*" v-model="cardName" required></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        v-model="accountName"
                                        :items="this.accounts.map(item=>item.name)"
                                        label="Account*"
                                        required
                                ></v-select>
                            </v-col>
                        </v-row>
                    </v-container>
                    <small>*indicates required field</small>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
                    <v-btn color="blue darken-1" text @click="save" >Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>
</template>

<script>
    import {mapState} from 'vuex'
    import { mapActions } from 'vuex'
    import router from "router/router";

    export default {
        computed: mapState(['accounts', 'cards', 'currencies', "profile"]),
        data()  {
            return {
                accountName: '',
                cardName: ' ',
                dialog: false,
            }
        },
        methods: {
            ...mapActions(['addCardAction', ]),
            getCardNames(){
                var names = [];
                this.currencies.map(elem => {
                    names.push( elem.name);
                });

                return names;
            },
            save() {
                if(!(this.accountName && this.cardName)){

                    return;
                }

                const acc = this.accounts.filter(elem=>elem.name===this.accountName)[0];
                const card = {
                    name: this.cardName,
                    account: acc,
                };

                this.addCardAction(card);
                this.dialog = false;
                router.go();
            },


    }

    }
</script>

<style scoped>

</style>