<script>
  import {clearUser} from '../../../stores/auth'
  import pb from '../../pocket';
  import { onMount } from 'svelte';
  import RecordCard from '../ui/RecordCard.svelte';

  const handleLogOut = async (e) => {
    pb.authStore.clear();
    clearUser();
    window.location.href = '/';
    Window.location.reload();
  }

  let records = [];  // Array to store all records
  let error = null;

  onMount(async () => {
    try {
      // Fetch all records from PocketBase collection
      const fetchedRecords = await pb.collection('medicalrecords').getFullList();
      records = fetchedRecords;
    } catch (err) {
      error = err;
      console.error("Error fetching records:", error);
    }
  });
</script>

<div class="min-h-full">
  <header class="bg-white shadow">
    <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
      <h1 class="text-3xl font-bold tracking-tight text-gray-900">Dashboard</h1>
    </div>
  </header>
  <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
    <a href='/create-record'><button class="bg-gray-800 bg-opacity-5 border-dashed border-4 border-zinc-800 border-opacity-15 text-gray-800 px-5 py-2 rounded-md">Create Record +</button></a>
    <button onclick={handleLogOut} class="bg-red-500 px-5 py-2 rounded-md text-white">Log-out?</button>
  </div>
    <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
      <h3 class="mt-4 text-xl">My Medical Records</h3>
      {#if error}
      <p>Error: {error.message}</p>
        {:else if records.length > 0}
      <div class="flex flex-wrap gap-1">
        {#each records as record}
          <a href='/view/{record.id}'><RecordCard {...record}/></a>
        {/each}
      </div>
        {:else}
      <p>Loading...</p>
        {/if}
    </div>
</div>