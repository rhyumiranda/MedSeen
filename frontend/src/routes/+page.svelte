<script>
  import { isAuthenticated } from '../stores/auth';
  import LandingPage from '../lib/components/pages/LandingPage.svelte';
  import Dashboard from '../lib/components/pages/Dashboard.svelte';
</script>

{#if $isAuthenticated}
  <Dashboard/>
{:else}
  <LandingPage/>
{/if}