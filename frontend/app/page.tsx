import Image from "next/image"

function Header() {

  return (

      <header className="flex space-x-20 p-fixed items-center justify-center mt-5" >
      <a href="#" className="pointer-event-none lg:pointer-events-auto lg:p-0">
        <Image src="/vercel.svg" alt="Home" className="object-fill" width={100} height={24} priority/>
      </a>
      <div className= "items-center bg-gray-100 rounded-lg">
        <form className="flex" action="search">
          <input className="bg-transparent h-10 w-96 ml-5 outline-none" type="text" name="content" autoComplete="off" placeholder="busque aqui seu produto"></input>
          <button>
            <i className="bx bx-search-alt-2 text-2xl p-1 mr-2" ></i>
          </button>
        </form>
      </div>
      <button className="flex space-x-2 items-center">
        <i className="bx bxs-user-circle text-4xl" ></i>
        <p>Login</p>
      </button>
    </header>
  )
}

export default function Home() {

  return (
  
    <Header/>
  )
}