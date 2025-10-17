```
Contact Manager - Flow

1. Accept user input to choose an action (Add, View, Search, Update, or Delete a contact).

2. If the user selects Add Contact:
- Ask for the contact name and phone number.
- Validate that the name is not empty and phone number has exactly 10 digits using regex.
- Check if the contact already exists in the ArrayList (case-sensitive match).
- If not, add the contact to the ArrayLists `names` and `phones`.

3. If the user selects View Contacts:
- Check if the ArrayList is empty.
- If not, display all saved contacts using a loop.

4. If the user selects Search Contact:
- Ask for the contact name.
- Search through the `names` ArrayList using exact match.
- If found, display the corresponding phone number using the index.
- Otherwise, show "Contact not found!"

5. If the user selects Update Contact:
- Ask for the existing contact name.
- If found, prompt the user to enter a new name and/or new phone number.
- Validate the new phone number if provided (must be 10 digits).
- Update the contact in the ArrayLists accordingly.

6. If the user selects Delete Contact:
- Ask for the contact name.
- Search and remove the contact from both `names` and `phones` ArrayLists using index.
- The search is case-insensitive.

7. The program runs continuously until the user chooses to exit.
```
