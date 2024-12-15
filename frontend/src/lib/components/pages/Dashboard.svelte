<script>
  import {clearUser} from '../../../stores/auth'
  import pb from '../../pocket';
  import { onMount } from 'svelte';

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

<style>
  .cards-container {
    display: flex;
    flex-wrap: wrap;
    gap: 16px;
  }

  .card {
    border: 1px solid #ddd;
    margin: 10px;
    padding: 20px;
    width: 200px;
    background-color: #f9f9f9;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }

  .card h2 {
    font-size: 1.2rem;
    margin-bottom: 8px;
  }

  .card p {
    font-size: 1rem;
    color: #555;
  }
</style>

<div class="min-h-full">
  <header class="bg-white shadow">
    <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
      <h1 class="text-3xl font-bold tracking-tight text-gray-900">Dashboard</h1>
    </div>
  </header>
  <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
    <button onclick={handleLogOut} class="bg-red-500 px-5 py-2 rounded-sm">Log-out?</button>

    <h3 class="mt-4 text-xl">My Medical Records</h3>

  </div>
    <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
      {#if error}
      <p>Error: {error.message}</p>
        {:else if records.length > 0}
      <div class="cards-container">
        {#each records as record}
          <div class="card">
            <h2>{record.title}</h2> <!-- Customize based on the record structure -->
            <p>{record.description}</p> <!-- Display other record details -->
          </div>
        {/each}
      </div>
        {:else}
      <p>Loading...</p>
        {/if}
    </div>
</div>