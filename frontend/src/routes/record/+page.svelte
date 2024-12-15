<script>
  import { onMount } from 'svelte';
  import pb from '../../lib/pocket';

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
