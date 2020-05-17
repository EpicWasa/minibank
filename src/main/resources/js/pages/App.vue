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

                <v-btn text href="/accounts">
                    Accounts
                </v-btn>
                <v-btn text href="/contracts"  >
                    Contracts
                </v-btn>
                <v-label class="pl-10">
                {{profile.name}}
                </v-label>
                <v-btn icon href="/logout">
                    <v-icon>{{logout}}</v-icon>
                </v-btn>
            </div>
            <div>
                <div v-if = "!profile"><v-btn href="/login">Sign in</v-btn></div>
            </div>
        </v-app-bar>

        <v-content>

            <router-view></router-view>

        </v-content>
    </v-app>
</template>

<script>
    import {mapState} from 'vuex'

    export default {
        components: {},
        comments:[],
        computed: mapState(['profile']),
        data() {
            return {
                logout: mdiExitToApp,
                balance: mdiBank,

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