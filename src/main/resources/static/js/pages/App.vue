<template>
    <v-app class="main-app">
        <v-app-bar app>
            <v-toolbar-title>
                <v-btn icon href="/">
                    <v-icon>{{balance}}</v-icon>
                </v-btn>
                Minibank
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <div v-if ="profile">
                {{profile.name}}
                <v-btn icon href="/logout">
                    <v-icon>{{logout}}</v-icon>
                </v-btn>
            </div>
            <div>
                <div v-if = "!profile"><v-btn href="/login">Sign in</v-btn></div>
            </div>
        </v-app-bar>
        <v-content>

            <account-list :cards="cards" :accounts="accounts">

            </account-list>

        </v-content>
    </v-app>
</template>

<script>
    import AccountList from 'components/AccountList.vue'

    export default {
        components: {
            AccountList
        },
        data() {
            return {
                logout: mdiExitToApp,
                balance: mdiBank,
                profile: frontendData.profile,
                accounts: frontendData.accounts,
                cards: frontendData.cards,
            }
        }
    }
    import { mdiExitToApp } from '@mdi/js'
    import {mdiBank} from '@mdi/js'

</script>

<style>
    .main-app{
    }
</style>