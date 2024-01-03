import React, { useEffect, useState } from 'react'
import BookService from '../services/BookService';

export default function BookTable() {
    const [bookArr, setBookArr] = useState([]);
    useEffect(()=>{
        BookService.getBooks().then((result)=>{
            setBookArr([...result.data]);
        })
    },[])
  return (
    <div>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            {bookArr.map(book=><tr key={book.id}>
                <th>{book.id}</th>
                <th>{book.name}</th>
                <th>{book.author}</th>
                <th>{book.price}</th>
            </tr>)}
            </tbody>
        </table>
        
    </div>
  )
}
