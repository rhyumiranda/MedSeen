<script>
  import { isAuthenticated } from '../stores/auth';
  import LandingPage from '../lib/components/pages/LandingPage.svelte';
  import Dashboard from '../lib/components/pages/Dashboard.svelte';
  import { onMount } from 'svelte';
  import { get } from 'svelte/store';

  let loading = true;

  onMount(() => {
    // Simulate an async check for authentication status
    setTimeout(() => {
      loading = false;
    }, 500); // Adjust the timeout as needed
  });
</script>

{#if loading}
  <p></p>
{:else}
  {#if $isAuthenticated}
    <Dashboard/>
  {:else}
    <LandingPage/>
  {/if}
{/if}