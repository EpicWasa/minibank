<template>
    <div>
        <div>
            <div v-if = "!profile"><a href="/login">Sign in</a></div>
            <div v-else ><a href="/logout">Log out</a>{{profile.name}}</div>
        </div>'
    </div>
</template>

<script>
    export default {
        data() {
            return {
                profile: frontendData.profile,
                accounts: frontendData.accounts,
                cards: frontendData.cards,
            }
        }
    }
</script>

<style>

</style>