<template>
  <v-app>

    <v-navigation-drawer
      v-model="drawer"
      app
      clipped
    >
      <v-list dense>
              <router-link to="/">
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
                Dashboard
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
              </router-link>
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              <router-link to="/about">
                Settings
              </router-link>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-group
          prepend-icon="mdi-view-dashboard"
        >
          <template v-slot:activator>
            <v-list-item-title>Users</v-list-item-title>
          </template>
          <v-list-group
            no-action
            sub-group
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title>Admin</v-list-item-title>
              </v-list-item-content>
            </template>
            <v-list-item link>
              <v-list-item-title v-text="123"></v-list-item-title>
            </v-list-item>
            <v-list-item link>
              <v-list-item-title v-text="456"></v-list-item-title>
            </v-list-item>
          </v-list-group>
        </v-list-group>
        <v-list-group
          prepend-icon="mdi-view-dashboard"
        >
          <template v-slot:activator>
            <v-list-item-title>Menu</v-list-item-title>
          </template>

          <v-list-item link>
            <v-list-item-content>
                <v-list-item-title>Sub Menu_1</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-group
            no-action
            sub-group
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title>Sub Menu_2</v-list-item-title>
              </v-list-item-content>
            </template>
            <v-list-item link>
              <v-list-item-title v-text="123"></v-list-item-title>
            </v-list-item>
            <v-list-item link>
              <v-list-item-title v-text="456"></v-list-item-title>
            </v-list-item>
          </v-list-group>
        </v-list-group>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      clipped-left
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>Application</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <button v-on:click="test">Greet</button>
      <router-view/>
    </v-content>

    <v-footer app>
      <span>&copy; 2020</span>
    </v-footer>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  props: {
    source: String
  },
  components: {
  },

  data: () => ({
    drawer: null
  }),
  created () {
    this.$vuetify.theme.dark = false
  },
  methods: {
    test: function () {
      alert('a')
      this.$axios.get('/api/users')
        .then((res) => {
          console.log(res)
        })
    }
  }
}
</script>
