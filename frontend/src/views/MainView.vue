<template>
  <v-app>
  <v-navigation-drawer
      v-model="drawer"
      app
      clipped
  >
    <AppSidebar/>
  </v-navigation-drawer>
    <v-app-bar
      app
      clipped-left
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>Application</v-toolbar-title>
    </v-app-bar>
    <v-content>
      <router-view/>
    </v-content>
    <AppFooter/>
  </v-app>
</template>

<script>
// @ is an alias to /src
import AppSidebar from '@/components/partials/AppSidebar.vue'
import AppFooter from '@/components/partials/AppFooter.vue'

export default {
  name: 'Main',
  components: {
    AppSidebar,
    AppFooter
  },
  props: {
    source: String
  },
  data: () => ({
    drawer: null
  })
}
</script>
