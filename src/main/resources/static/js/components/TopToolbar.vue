<template>

    <v-app-bar app>
        <v-toolbar-title>
            <v-btn icon href="/">
                <v-icon>{{balance}}</v-icon>
            </v-btn>
            Minibank
        </v-toolbar-title>
        <v-spacer></v-spacer>
        <v-toolbar-items>
            <v-container v-if ="profile">

                <div>
                    <v-btn href="/accounts" text large>
                        Accounts
                    </v-btn>

                    <v-btn href="/contracts" text large>
                        Contracts
                    </v-btn>
                    {{profile.name}}
                    <v-btn icon href="/logout">
                        <v-icon>{{logout}}</v-icon>
                    </v-btn>
                </div>
            </v-container>
            <v-container>
                <div v-if = "!profile"><v-btn href="/login">Sign in</v-btn></div>
            </v-container>
        </v-toolbar-items>
    </v-app-bar>

</template>

<script>
    import { mdiExitToApp } from '@mdi/js'
    import {mdiBank} from '@mdi/js'

    export default {
        name: "Toolbar",
        logout: mdiExitToApp,
        balance: mdiBank,
    }
</script>

<style scoped>

</style>