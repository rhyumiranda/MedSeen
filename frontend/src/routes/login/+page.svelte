<script>
  import {setUser, clearUser, user} from '../../stores/auth';
  import pb from '$lib/pocket';

  let email = '';
  let password = '';

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      
      const authData = await pb.collection("users").authWithPassword(email, password);
      setUser(authData.record);
      window.location.href = '/';
    } catch (error) {
      alert('Login failed: ' + error.message);
    }

  }
</script>
<div class="flex min-h-screen flex-col justify-center items-center px-6 py-12 lg:px-8 mx-auto">
  <div class="sm:mx-auto sm:w-full sm:max-w-sm">
    <img class="mx-auto h-5 w-auto" src="/medseen.png" alt="Medseen Company">
    <h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-gray-900">Sign in to your account</h2>
  </div>

  <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
    <form on:submit|preventDefault={handleLogin} class="space-y-6" action="#" method="POST">
      <div>
        <label for="email" class="block text-sm/6 font-medium text-gray-900">Email address</label>
        <div class="mt-2">
          <input bind:value={email} type="email" name="email" id="email" autocomplete="email" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
        </div>
      </div>

      <div>
        <div class="flex items-center justify-between">
          <label for="password" class="block text-sm/6 font-medium text-gray-900">Password</label>
          <div class="text-sm">
            <a href="/register" class="font-semibold text-indigo-600 hover:text-indigo-500">Forgot password?</a>
          </div>
        </div>
        <div class="mt-2">
          <input bind:value={password} type="password" name="password" id="password" autocomplete="current-password" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6">
        </div>
      </div>

      <div>
        <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Sign in</button>
      </div>
    </form>

    <p class="mt-10 text-center text-sm/6 text-gray-500">
      Not a member?
      <a href="/register" class="font-semibold text-indigo-600 hover:text-indigo-500">Get Started</a>
    </p>
  </div>
</div>

